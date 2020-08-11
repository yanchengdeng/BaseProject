package com.dyc.common.api.exception


class ResultException(var errCode: String?, var msg: String?) : Exception(msg)
