package com.jy.jiandao.data.repository;

import com.jy.jiandao.auth.register.RegisterContract;
import com.mr.k.mvp.base.IBaseCallBack;

import java.util.Map;

/*
 * created by Cherry on 2019-12-27
 **/
public class RegisterRepository extends BaseRepository implements RegisterContract.IRegisterMode {


    @Override
    public void getSmsCode(Map<String, String> params, IBaseCallBack<String> callBack) {

       // observer(JDDataService.getApiService().getVerificationCode(params),this::getConvertObservable,callBack);


    }

    @Override
    public void verifySmsCode(Map<String, String> params, IBaseCallBack<String> callBack) {

      //  observer(JDDataService.getApiService().getCheckVerificationCode(params),this::getConvertObservable,callBack);

    }
}
