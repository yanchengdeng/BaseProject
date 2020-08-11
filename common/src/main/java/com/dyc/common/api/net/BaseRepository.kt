package com.dyc.common.api.net


import com.dyc.common.api.exception.DealException
import com.dyc.common.api.exception.ResultException
import com.dyc.common.api.model.BaseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import com.dyc.common.api.model.NetResult
import com.dyc.common.constants.Constants

open class BaseRepository {

    suspend fun <T : Any> callRequest(
        call: suspend () -> NetResult<T>
    ): NetResult<T> {
        return try {
            call()
        } catch (e: Exception) {
            //这里统一处理异常
            e.printStackTrace()
            NetResult.Error(DealException.handlerException(e))
        }
    }

    suspend fun <T : Any> handleResponse(
        response: BaseModel<T>,
        successBlock: (suspend CoroutineScope.() -> Unit)? = null,
        errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): NetResult<T> {
        return coroutineScope {
            if (response.errorCode == Constants.SUCCESS_CODE){
                successBlock?.let { it() }
                NetResult.Success(response.data)
            }else{
                errorBlock?.let { it() }
                NetResult.Error(
                    ResultException(
                        response.errorCode.toString(),
                        response.errorMsg
                    )
                )
            }
        }
    }
}