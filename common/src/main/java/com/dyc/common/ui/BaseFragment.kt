package com.dyc.common.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

/**
 *@Author : yancheng
 *@Date : 2020/8/6
 *@Time : 11:05
 *@Describe ：
 **/

abstract class BaseFragment: Fragment(){


    //初始化布局
    abstract fun initView()

    //初始化数据
    abstract fun initData()

    //布局
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()

    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}