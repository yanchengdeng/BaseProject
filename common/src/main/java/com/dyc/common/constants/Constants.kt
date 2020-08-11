package com.dyc.common.constants

/**
 *@Author : yancheng
 *@Date : 2020/8/4
 *@Time : 15:00
 *@Describe ：
 **/

object Constants {
    /**
     * 调试模式
     */
    private var isDebug = false

    /**
     * api 成功 code  默认
     */
     var SUCCESS_CODE = 0


    fun setDebug(isDebug :Boolean){
        this.isDebug = isDebug
    }

    fun isDebug()= isDebug


    fun setSuccessCode(code :Int){
        this.SUCCESS_CODE = code
    }

}