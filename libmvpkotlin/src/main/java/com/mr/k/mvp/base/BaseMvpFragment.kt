package com.mr.k.mvp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trello.rxlifecycle2.LifecycleProvider

 abstract class BaseMvpFragment<D, V : IBaseMvpView<D>, P : IBaseMvpPresenter<V>> : BaseFragment(),IBaseMvpView<D>{

     var mPresenter: P? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mPresenter = createPresenter()?.apply {


            attachView(this@BaseMvpFragment as V)

        }


        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onDestroyView() {
        super.onDestroyView()

        mPresenter?.run {
            detachView()
        }


    }

    override fun getProvider(): LifecycleProvider<*> = this



   abstract fun createPresenter() : P

}