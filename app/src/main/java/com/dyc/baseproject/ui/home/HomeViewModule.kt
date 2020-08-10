package com.dyc.baseproject.ui.home

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyc.baseproject.data.ResultData
import com.dyc.baseproject.repository.HomeRepository
import kotlinx.coroutines.launch

class HomeViewModule(private val repository: HomeRepository) : ViewModel() {


    companion object {
        const val CHECK_SUCCESS = 0
        const val INPUT_USERNAME_EMPTY = 1
        const val INPUT_PASSWORD_EMPTY = 2
    }

    private val username: MutableLiveData<String> = MutableLiveData()
    private val password: MutableLiveData<String> = MutableLiveData()

    var wanParts: MutableLiveData<ResultData> = MutableLiveData()

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
            wanParts.postValue(repository.getWanParts())
        }
    }


}