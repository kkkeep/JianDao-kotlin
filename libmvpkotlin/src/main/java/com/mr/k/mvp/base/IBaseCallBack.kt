package com.mr.k.mvp.base

import com.mr.k.mvp.exception.ResultException

/*
 * created by Cherry on 2019-12-20
 **/
interface IBaseCallBack<T> {
    fun onSuccess(data: T)
    fun onFail(e: ResultException)
}