package com.mr.k.mvp.base

import com.trello.rxlifecycle2.LifecycleProvider

/*
 * created by Cherry on 2019-12-20
 **/
interface IBaseMvpPresenter2<V> {

    fun attachView(view: V)
    fun detachView()


    val provider: LifecycleProvider<*>?
}