package com.mr.k.mvp.base;

import androidx.annotation.NonNull;

import io.reactivex.disposables.Disposable;

/*
 * created by Cherry on 2019-12-20
 **/
public interface ICancelableCallBack<T> extends IBaseCallBack<T> {
    void onStart(@NonNull Disposable disposable);
}
