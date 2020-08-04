package com.dyc.baseproject

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.dyc.common.constants.Constants

/**
 *@Author : yancheng
 *@Date : 2020/7/31
 *@Time : 9:59
 *@Describe ：
 **/
class MyApplication  :Application(){

    override fun onCreate() {
        super.onCreate()

        Constants.setDebug(true)
        if (Constants.isDebug()) {
            ARouter.openDebug()
            ARouter.openLog()
        }

        ARouter.init(this)
    }
}