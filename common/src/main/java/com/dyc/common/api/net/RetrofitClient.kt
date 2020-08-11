package com.dyc.common.api.net


import com.dyc.common.api.interceptor.BasicParamsInterceptor
import com.dyc.common.api.interceptor.HeaderInterceptor
import com.dyc.common.api.interceptor.LoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient private constructor() {

    private var retrofit: Retrofit

    companion object {
        val instance: RetrofitClient by lazy { RetrofitClient() }
    }


    init {

        retrofit = Retrofit.Builder()
            .client(initClient())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.wanandroid.com")
            .build()

    }

    private fun initClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(LoggingInterceptor())
            .addInterceptor(HeaderInterceptor())
            .addInterceptor(BasicParamsInterceptor())
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
    }


    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }


}