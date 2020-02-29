package com.jy.jiandao.data.ok;

import com.mr.k.mvp.oknet.MvpDataService;


/*
 * created by Cherry on 2019-12-26
 **/
public class JDDataService {

    public static ApiService getApiService(){
       return (ApiService) MvpDataService.INSTANCE.getAppApiServide();
    }


}
