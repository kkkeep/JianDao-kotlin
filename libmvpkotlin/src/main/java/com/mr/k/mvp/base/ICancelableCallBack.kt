package com.mr.k.mvp.base

import io.reactivex.disposables.Disposable

/*
 * created by Cherry on 2019-12-20
 **/
interface ICancelableCallBack<T> : IBaseCallBack<T> {
    fun onStart(disposable: Disposable)
}