package com.mr.k.mvp.base;

import com.trello.rxlifecycle2.LifecycleProvider;

/*
 * created by Cherry on 2019-12-20
 **/
public class BasePresenter<V extends IBaseMvpView> implements IBaseMvpPresenter<V> {

    protected V mView;

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public LifecycleProvider getProvider() {
        return (LifecycleProvider) mView;
    }




}
