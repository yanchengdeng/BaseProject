package com.dyc.baseproject.di

import com.dyc.common.api.net.RetrofitClient
import com.dyc.module_login.di.loginReposModule
import com.dyc.module_login.di.loginViewModelModule
import com.dyc.module_main.di.mainReposModule
import com.dyc.module_main.di.mainViewModelModule
import org.koin.dsl.module

/**
 *@Author : yancheng
 *@Date : 2020/8/7
 *@Time : 17:39
 *@Describe ：
 **/



val otherModule = module {
    single {
        RetrofitClient.instance
    }
}




val app_module = listOf(
    otherModule,
    loginViewModelModule, loginReposModule,
    mainViewModelModule,mainReposModule

)
