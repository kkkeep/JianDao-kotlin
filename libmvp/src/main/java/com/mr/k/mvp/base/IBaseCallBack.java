package com.mr.k.mvp.base;

import com.mr.k.mvp.exception.ResultException;

/*
 * created by Cherry on 2019-12-20
 **/
public interface IBaseCallBack<T> {

    void onSuccess(T data);

    void onFail(ResultException e);
}
