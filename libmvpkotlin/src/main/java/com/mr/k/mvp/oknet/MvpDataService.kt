package com.mr.k.mvp.oknet

import com.mr.k.mvp.BuildConfig
import com.mr.k.mvp.MvpManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object MvpDataService {

    private const val DEFAULT_TIMEOUT: Long = 20000 // 默认超时20s

    private var appApiService: Any? = null

    private var mvpApiService: MvpApiService? = null

    private val retrofit: Retrofit


    init {

        val logging = HttpLoggingInterceptor()
        /**
         * 注意，如果有大文件下载，或者 response 里面的body 很大，要么不加HttpLoggingInterceptor 拦截器
         * 如果非要加，日志级别不能是 BODY,否则容易内存溢出。
         */

        if (BuildConfig.DEBUG) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.NONE)
        }


        val builder = OkHttpClient.Builder()
        builder.addInterceptor(logging)

        MvpManager.netConfig.interceptor?.apply {
            onEach {
                builder.addInterceptor(it)
            }
        }


        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(
                DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS
            ).build()

        retrofit = Retrofit.Builder()
            .client(builder.build())
            .addConverterFactory(
                MvpManager.netConfig.factory ?: GsonConverterFactory.create()
            ) // 帮我们把json 窜转为 entity 对象
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 结合 rxjava 使用
            .baseUrl(MvpManager.netConfig.baseUrl)
            .build()

    }

    @Synchronized
    fun getAppApiServide(): Any? {

        if (appApiService == null) {

            appApiService = retrofit.create(MvpManager.netConfig.appApiService)

        }

        return appApiService
    }


    @Synchronized
     fun getMvppiServide(): MvpApiService? {

        if (mvpApiService == null) {

            mvpApiService = retrofit.create(MvpApiService::class.java)

        }

        return mvpApiService
    }


}