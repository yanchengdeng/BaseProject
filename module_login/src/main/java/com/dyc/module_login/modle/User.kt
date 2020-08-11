package com.dyc.module_login.modle

import java.io.Serializable

/**
 *@Author : yancheng
 *@Date : 2020/8/11
 *@Time : 14:29
 *@Describe ：
 **/

class User (
    val id: Int = 0,
    val username: String ,
    val icon: String = "",
    val email: String = "",
    val password: String
):Serializable