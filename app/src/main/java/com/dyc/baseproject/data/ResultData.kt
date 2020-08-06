package com.dyc.baseproject.data

/**
 *@Author : yancheng
 *@Date : 2020/8/6
 *@Time : 16:14
 *@Describe ：
 **/

/**
 *
 * data :[]/{}
 *   "errorCode": 0,
"errorMsg": "
 */

data class ResultData(val errorCode: Int, val errorMsg: String, val data: List<WanPart>)

data class WanPart(
    val id: Int,
    val link: String,
    val name: String,
    val order: Int,
    val visible: Int
)

