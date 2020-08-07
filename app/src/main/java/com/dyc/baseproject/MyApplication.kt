package com.dyc.baseproject

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.dyc.baseproject.di.app_module
import com.dyc.common.constants.Constants
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 *@Author : yancheng
 *@Date : 2020/7/31
 *@Time : 9:59
 *@Describe ：
 **/
class MyApplication  :Application(){



    override fun onCreate() {
        super.onCreate()

        //设置全局开发模式   包括 日志 、
        Constants.setDebug(true)
        if (Constants.isDebug()) {
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(this)


        //koin 注解
        startKoin {
            androidContext(this@MyApplication)
            modules(app_module)

        }
    }
}