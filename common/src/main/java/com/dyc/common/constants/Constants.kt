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
    fun setDebug(isDebug :Boolean){
        this.isDebug = isDebug
    }

    fun isDebug()= isDebug



}