package com.mr.k.mvp

import android.content.Context
import androidx.annotation.IntDef
import com.mr.k.mvp.oknet.NetConfig

object MvpManager {
    const val REQUEST_FIRST_LOAD = 0x200 // 第一次加载请求
    const val REQUEST_REFRESH_LOAD = 0x300 // 刷新请求
    const val REQUEST_LOAD_MORE_LOAD = 0x400 // 加载更多请求
    const val RESPONSE_FROM_MEMORY = 0X100 // 数据从内存返回
    const val RESPONSE_FROM_SDCARD = 0X200 // 数据从sdcard 返回，
    const val RESPONSE_FROM_SERVER = 0X300 // 数据从服务器返回

    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    @IntDef(
        REQUEST_FIRST_LOAD,
        REQUEST_REFRESH_LOAD,
        REQUEST_LOAD_MORE_LOAD
    )
    annotation class RequestType

    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    @IntDef(
        RESPONSE_FROM_MEMORY,
        RESPONSE_FROM_SDCARD,
        RESPONSE_FROM_SERVER
    )
    annotation class ResponseType


    lateinit var context : Context

    lateinit var netConfig: NetConfig



    fun initMvp(context: Context,netConfig: NetConfig){

        this.context = context.applicationContext

        this.netConfig = netConfig
    }
}