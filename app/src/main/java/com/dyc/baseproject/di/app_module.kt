package com.dyc.baseproject.di

import com.dyc.baseproject.apiwork.HomeApi
import com.dyc.baseproject.apiwork.HomeService
import com.dyc.baseproject.repository.HomeRepository
import com.dyc.baseproject.ui.home.HomeViewModule
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *@Author : yancheng
 *@Date : 2020/8/7
 *@Time : 17:39
 *@Describe ：
 **/

val viewModelModule = module {
    viewModel { HomeViewModule(get()) }
}

val reposModule = module {
    factory { HomeRepository(get()) }
}

val remoteModule = module {
    single<HomeApi> { HomeService }
}


val localModule = module {
//    single { userDao }
}


val app_module = listOf(viewModelModule, reposModule, remoteModule, localModule)
