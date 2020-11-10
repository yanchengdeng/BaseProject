package com.dyc.common.view

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 *@Author : yancheng
 *@Date : 2020/11/3
 *@Time : 10:32
 *@Describe ：ImageView 操作
 **/


fun ImageView.load(context: Context,url : String,round :Int = 0,defaultImage : Int){
    Glide.with(this.context).load(url)
}