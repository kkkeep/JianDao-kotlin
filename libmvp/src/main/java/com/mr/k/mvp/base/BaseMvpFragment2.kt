package com.mr.k.mvp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

open abstract class BaseMvpFragment2<P : IBaseMvpPresenter2<Any>> : BaseFragment(),IBaseMvpView2<P>{

    protected var mPresenter: P? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mPresenter = createPresenter()?.apply {
            attachView(this@BaseMvpFragment2)
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onDestroyView() {
        super.onDestroyView()

        mPresenter?.run {
            detachView()
        }


    }

}