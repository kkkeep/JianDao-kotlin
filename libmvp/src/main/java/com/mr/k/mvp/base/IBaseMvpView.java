package com.mr.k.mvp.base;

/*
 * created by Cherry on 2019-12-20
 **/
public interface IBaseMvpView<P extends  IBaseMvpPresenter> {

    P createPresenter();



}
