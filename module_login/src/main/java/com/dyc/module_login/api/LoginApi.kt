package com.dyc.module_login.api

import com.dyc.common.api.model.BaseModel
import com.dyc.module_login.modle.User
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 *@Author : yancheng
 *@Date : 2020/8/11
 *@Time : 10:19
 *@Describe ：
 **/

interface LoginApi {

    @FormUrlEncoded
    @POST("/user/login")
    suspend fun doLogin(@Field("username") username: String, @Field("password") password: String): BaseModel<User>

}