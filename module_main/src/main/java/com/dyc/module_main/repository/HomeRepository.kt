package com.dyc.module_main.repository

import com.dyc.common.api.net.BaseRepository
import com.dyc.common.api.net.RetrofitClient
import com.dyc.module_main.api.HomeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *@Author : yancheng
 *@Date : 2020/8/6
 *@Time : 15:46
 *@Describe ：
 **/
class HomeRepository(private val retrofit: RetrofitClient) : BaseRepository() {

//    suspend fun getWanParts() = withContext(Dispatchers.IO){
//        retrofit.create(HomeApi::class.java).getWanParts()
//    }


    suspend fun getWanParts() = callRequest(call = {requestWanParts()})


    private suspend fun requestWanParts() = handleResponse(retrofit.create(HomeApi::class.java).getWanParts())

}