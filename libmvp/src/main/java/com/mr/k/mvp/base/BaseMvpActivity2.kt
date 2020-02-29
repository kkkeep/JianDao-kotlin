package com.mr.k.mvp.base

import android.os.Bundle

/*
 * created by Cherry on 2019-12-20
 **/
abstract class BaseMvpActivity2<P : IBaseMvpPresenter2<Any>> : BaseActivity(), IBaseMvpView2<P> {

    protected var mPresenter: P? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter()?.apply {
            attachView(this@BaseMvpActivity2)
        }

    }

    override fun onDestroy() {
        super.onDestroy()

        mPresenter?.run {
            detachView()
        }

    }
}