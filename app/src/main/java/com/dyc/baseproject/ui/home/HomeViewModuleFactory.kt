package com.dyc.baseproject.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dyc.baseproject.repository.HomeRepository

/**
 *@Author : yancheng
 *@Date : 2020/8/6
 *@Time : 14:15
 *@Describe ：
 **/

class HomeViewModuleFactory constructor(private val repository :HomeRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModule(repository) as T
    }

}