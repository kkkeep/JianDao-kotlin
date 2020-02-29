package com.jy.jiandao.data.repository;

import com.jy.jiandao.auth.register.RegisterContract;
import com.jy.jiandao.data.entity.User;
import com.jy.jiandao.data.ok.JDDataService;
import com.mr.k.mvp.base.IBaseCallBack;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.Map;

/*
 * created by Cherry on 2020-01-02
 **/
public class RegisterSetRepository extends BaseRepository implements RegisterContract.IRegisterSetMode {


    @Override
    public void register(LifecycleProvider provider, Map<String, String> params, IBaseCallBack<User> callBack) {
            observer(provider,JDDataService.getApiService().register(params),this::getConvertObservable,callBack);


    }

}
