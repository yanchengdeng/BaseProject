package com.dyc.common.api.model

/**
 * 接口返回的基础数据模板
 */
data class BaseModel<out T>(val errorCode: Int, val errorMsg: String, val data: T)