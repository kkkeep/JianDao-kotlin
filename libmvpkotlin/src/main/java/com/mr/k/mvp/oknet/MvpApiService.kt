package com.mr.k.mvp.oknet

import io.reactivex.Observable
import retrofit2.http.*

public interface MvpApiService{


    @GET
    operator fun get(@Url url: String, @QueryMap params: Map<String, String>?): Observable<String>

    @GET
    operator fun get(@Url url: String, @HeaderMap headers: Map<String, String>?, @QueryMap params: Map<String, String>?): Observable<String>

    @POST
    @FormUrlEncoded
    fun post(@Url url: String, @FieldMap params: Map<String, String>): Observable<String>

    @POST
    @FormUrlEncoded
    fun post(@Url url: String, @HeaderMap headers: Map<String, String>?, @FieldMap params: Map<String, String>?): Observable<String>
}