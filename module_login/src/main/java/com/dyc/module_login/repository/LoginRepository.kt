package com.dyc.module_login.repository

import com.dyc.common.api.net.BaseRepository
import com.dyc.common.api.net.RetrofitClient
import com.dyc.module_login.api.LoginApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@Author : yancheng
 *@Date : 2020/8/11
 *@Time : 9:45
 *@Describe ：
 **/


class LoginRepository (private val retrofit: RetrofitClient) : BaseRepository(){

//    suspend fun doLogin(username: String, password: String)  = withContext(Dispatchers.IO){
//        retrofit.create(LoginApi::class.java).doLogin(username,password)
//    }

    suspend fun login(username: String,password: String) = callRequest(call = {requestLogin(username,password)})

    private suspend fun requestLogin(username: String, password: String) = handleResponse(retrofit.create(LoginApi::class.java).doLogin(username,password))


}
