package com.mr.k.mvp.base

import com.mr.k.mvp.MvpManager
import com.trello.rxlifecycle2.LifecycleProvider

interface IBaseMvpView<D>{


   fun onSuccess(data : D,requestType: Int, responseTye : Int)


    fun onFail(errorMsg : String , responseTye: Int)


    fun getProvider() : LifecycleProvider<*>


}