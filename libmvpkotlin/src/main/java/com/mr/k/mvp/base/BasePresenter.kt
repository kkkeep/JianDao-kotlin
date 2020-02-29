package com.mr.k.mvp.base

import com.mr.k.mvp.MvpManager
import com.mr.k.mvp.exception.ResultException
import com.trello.rxlifecycle2.LifecycleProvider

/*
 * created by Cherry on 2019-12-20
 **/
open class BasePresenter<D,V : IBaseMvpView<D>>  : IBaseMvpPresenter<V>{

    protected  var mView : V? = null

    private var mBaseRepository : BaseRepository

    constructor(){
        mBaseRepository = BaseRepository()
    }

    constructor(baseRepository: BaseRepository) {
        this.mBaseRepository = baseRepository
    }




    override fun attachView(view: V) {

        mView = view
    }

    override fun detachView() {

        mView = null
    }



    public open fun getData(paramsMap: ParamsMap, requestCode : Int = MvpManager.REQUEST_FIRST_LOAD,responseCode : Int = MvpManager.RESPONSE_FROM_SERVER){
        mView?.run {
            mBaseRepository.get(getProvider(),paramsMap,object : IBaseCallBack<D>{
                override fun onSuccess(data: D) {
                    this@run.onSuccess(data ,requestCode,MvpManager.RESPONSE_FROM_SERVER)


                }

                override fun onFail(e: ResultException) {
                    this@run.onFail(e.message,responseCode)
                }

            })
        }



    }

}