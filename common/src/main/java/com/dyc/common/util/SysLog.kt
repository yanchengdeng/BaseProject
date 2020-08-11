package com.dyc.common.util

import com.blankj.utilcode.util.LogUtils
import com.dyc.common.constants.Constants

/**
 *@Author : yancheng
 *@Date : 2020/8/4
 *@Time : 15:00
 *@Describe ：日志输出
 **/
object SysLog {

    private const val TAG = "yancheng"

    fun d(tag: String = TAG, msg :String){
        if (Constants.isDebug()){
            LogUtils.dTag(tag,msg)
        }
    }


    fun i(tag : String = TAG,msg :String){
        if (Constants.isDebug()){
            LogUtils.iTag(tag,msg)
        }
    }

    fun e(tag : String = TAG,msg :String){
        if (Constants.isDebug()){
            LogUtils.eTag(tag,msg)
        }
    }
}