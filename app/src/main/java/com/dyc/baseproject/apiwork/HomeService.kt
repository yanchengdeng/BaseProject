package com.dyc.baseproject.apiwork

import androidx.lifecycle.LiveData
import com.dyc.baseproject.data.ResultData
import com.dyc.baseproject.data.WanPart
import retrofit2.Call
import retrofit2.http.GET

/**
 *@Author : yancheng
 *@Date : 2020/8/6
 *@Time : 16:13
 *@Describe ：
 **/

interface HomeService{


    @GET("hotkey/json")
   suspend fun getWanParts() : ResultData




}
