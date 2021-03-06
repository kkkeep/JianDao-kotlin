package com.jy.jiandao.data.repository;

import com.jy.jiandao.data.entity.ColumnData;
import com.jy.jiandao.data.ok.JDDataService;
import com.jy.jiandao.home.recommend.RecommendContract;
import com.mr.k.mvp.base.IBaseCallBack;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.Map;

/*
 * created by Cherry on 2020-01-08
 **/
public class RecommendRepository extends BaseRepository implements RecommendContract.IRecommendMode {
    @Override
    public void getColumnList(LifecycleProvider provider, Map<String,String> params,IBaseCallBack<ColumnData> callBack) {

        observer(provider,JDDataService.getApiService().getColumnList(params), this::getConvertObservable, callBack);
    }
}
