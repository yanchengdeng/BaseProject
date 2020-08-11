package com.dyc.module_login.di

import com.dyc.common.api.net.RetrofitClient
import com.dyc.module_login.repository.LoginRepository
import com.dyc.module_login.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *@Author : yancheng
 *@Date : 2020/8/11
 *@Time : 15:44
 *@Describe ：
 **/


val loginViewModelModule = module {
    viewModel { LoginViewModel(get()) }
}

val loginReposModule = module {
    factory { LoginRepository(get()) }
}

