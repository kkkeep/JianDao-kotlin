package com.mr.k.mvp.oknet

import com.mr.k.mvp.base.IEntity
import okhttp3.Interceptor
import retrofit2.Converter
import java.lang.IllegalArgumentException

class NetConfig constructor(val baseUrl : String) {

    var appApiService : Class<*> ? = null

    var interceptor : List<Interceptor> ? = null

    var factory : Converter.Factory ? = null

     var httpData : Class<*>? = null

    set(value) {
        if(value!!.newInstance() is IEntity<*>){
            field = value
        }else{
            throw IllegalArgumentException("给 httpData 复制时，请传入 实现了IEntity 的子类 class")
        }
    }


}