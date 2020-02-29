package com.mr.k.mvp.base

import com.trello.rxlifecycle2.LifecycleProvider

/*
 * created by Cherry on 2019-12-20
 **/
interface IBaseMvpPresenter<V : IBaseMvpView<*>> {

    fun attachView(view: V)
    fun detachView()



}