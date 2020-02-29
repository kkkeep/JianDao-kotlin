package com.mr.k.mvp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trello.rxlifecycle2.LifecycleProvider

 abstract class BaseMvpFragment2<D> : BaseMvpFragment<D,IBaseMvpView<D>,BasePresenter<D,IBaseMvpView<D>>>(){



     override fun createPresenter(): BasePresenter<D, IBaseMvpView<D>> {
         return BasePresenter()
     }


}