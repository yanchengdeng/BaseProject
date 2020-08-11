package com.dyc.module_main.ui.home

import android.app.Application
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.ToastUtils
import com.dyc.common.api.model.BaseModel
import com.dyc.common.api.model.NetResult
import com.dyc.module_main.modle.WanPart
import com.dyc.module_main.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository ) : ViewModel() {


    companion object {
        const val CHECK_SUCCESS = 0
        const val INPUT_USERNAME_EMPTY = 1
        const val INPUT_PASSWORD_EMPTY = 2
    }

    private val username: MutableLiveData<String> = MutableLiveData()
    private val password: MutableLiveData<String> = MutableLiveData()

    var wanParts: MutableLiveData<List<WanPart>> = MutableLiveData()

    /**
     * 检查登录数据完整性
     */
    fun checkParams(username: String, password: String) =
        when {
            TextUtils.isEmpty(username) -> {
                INPUT_USERNAME_EMPTY
            }
            TextUtils.isEmpty(password) -> {
                INPUT_PASSWORD_EMPTY
            }
            else -> {
                this.username.value = username
                this.password.value = password
                CHECK_SUCCESS
            }
        }


    fun doLogin() {
        viewModelScope.launch {
            val wanPartDatas = repository.getWanParts()
            if (wanPartDatas is NetResult.Success){
                wanParts.postValue (wanPartDatas.data)
            }else if (wanPartDatas is NetResult.Error){
                ToastUtils.showShort(wanPartDatas.exception.msg)
            }
        }
    }
}