package com.jy.jiandao.data.repository;

import com.jy.jiandao.auth.login.PasswordLoginContract;
import com.jy.jiandao.data.entity.User;
import com.jy.jiandao.data.ok.JDDataService;
import com.mr.k.mvp.base.IBaseCallBack;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.Map;

/*
 * created by Cherry on 2020-01-03
 **/
public class PasswordLoginRepository extends BaseRepository implements PasswordLoginContract.IPasswordLoginMode {

    @Override
    public void login(LifecycleProvider provider, Map<String, String> params, IBaseCallBack<User> callBack) {
        observer(provider,JDDataService.getApiService().login(params), this::getConvertObservable,callBack);
    }




}
