package com.dyc.baseproject.repository

import com.dyc.baseproject.apiwork.HomeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@Author : yancheng
 *@Date : 2020/8/6
 *@Time : 15:46
 *@Describe ：
 **/
class HomeRepository(private val homeApi: HomeApi) {

    suspend fun getWanParts() = withContext(Dispatchers.IO){
        homeApi.getWanParts()
    }


//    companion object{
//        // For Singleton instantiation
//        @Volatile private var instance: HomeRepository? = null
//
//        fun getInstance() : HomeRepository =
//            instance ?: synchronized(this){
//                instance ?: HomeRepository(get()).also {
//                    instance = it
//                }
//            }
//    }

}