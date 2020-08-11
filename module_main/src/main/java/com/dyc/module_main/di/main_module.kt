package com.dyc.module_main.di

import com.dyc.module_main.ui.home.HomeViewModel
import com.dyc.module_main.repository.HomeRepository
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val mainViewModelModule = module {
    viewModel { HomeViewModel(get()) }
}

val mainReposModule = module {
    single { HomeRepository(get()) }
}

val MainRemoteModule = module {

    //可存放本地数据库 实例化
   
}