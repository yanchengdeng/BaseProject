package com.dyc.module_main.api

import com.dyc.common.api.model.BaseModel
import com.dyc.module_main.modle.WanPart
import retrofit2.http.GET

/**
 *@Author : yancheng
 *@Date : 2020/8/6
 *@Time : 16:13
 *@Describe ：
 **/

interface HomeApi{


    @GET("hotkey/json")
   suspend fun getWanParts() : BaseModel<List<WanPart>>




}
