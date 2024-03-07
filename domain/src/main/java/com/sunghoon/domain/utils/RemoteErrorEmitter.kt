package com.sunghoon.domain.utils

interface RemoteErrorEmitter {
    fun onError(msg:String)
    fun onError(errorType: ErrorType)
}