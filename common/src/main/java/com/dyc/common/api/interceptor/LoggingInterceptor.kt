package com.dyc.common.api.interceptor

import com.dyc.common.util.SysLog
import okhttp3.Interceptor
import okhttp3.Response
import okio.BufferedSource
import java.io.IOException
import java.nio.charset.Charset

/**
 *@Author : yancheng
 *@Date : 2020/8/11
 *@Time : 11:23
 *@Describe ：
 **/


class LoggingInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val t1 = System.nanoTime()
        SysLog.d(msg =  "发送请求: ${request.url()} \n ${request.headers()}")
//            OkHttp请求回调中response.body().string()只能有效调用一次
        val response = chain.proceed(request)
        val t2 = System.nanoTime()
        SysLog.d(msg =  "接口时长 :  ${response.request().url()} in ${(t2 - t1) / 1e6} ms \n Headers数据：\n${response.headers()}")
        val responseBody = response.body()
        responseBody?.apply {
            val source: BufferedSource = source()
            source.request(Long.MAX_VALUE) // Buffer the entire body.
            val buffer = source.buffer
            //获取Response的body的字符串 并打印
            val result = (buffer.clone().readString(Charset.defaultCharset()))
            SysLog.d(tag = "返回数据",msg =  result)
        }
        return response
    }
}