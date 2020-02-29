package com.jy.jiandao.data;

import com.mr.k.mvp.base.IEntity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/*
 * created by Cherry on 2019-12-26
 **/
public class HttpResult<D> implements IEntity {

    public String message;
    public int code;
    public D data;

    @Override
    public int getCode() {
        return code;
    }

    @NotNull
    @Override
    public String getMessage() {
        return message ;
    }

    @Nullable
    @Override
    public D getData() {
        return data;
    }




   /* @Override
    public int getCode() {
        return code;
    }

    @NotNull
    @Override
    public String getMessage() {
        return message;
    }


    @Override
    public D getData() {
        return data;
    }*/
}



