package com.mr.k.mvp.base

import android.os.Bundle

/*
 * created by Cherry on 2019-12-20
 **/
abstract class BaseMvpActivity<D,P : IBaseMvpPresenter> : BaseActivity(), IBaseMvpView<D,P> {

    protected var mPresenter: IBaseMvpPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = createPresenter().apply {
            attachView(this@BaseMvpActivity)


        }

    }

    override fun onDestroy() {
        super.onDestroy()

        mPresenter?.run {
            detachView()
        }

    }
}