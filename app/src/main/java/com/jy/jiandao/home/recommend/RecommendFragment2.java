package com.jy.jiandao.home.recommend;

import com.jy.jiandao.data.entity.ColumnData;
import com.mr.k.mvp.base.BaseMvpFragment;
import com.mr.k.mvp.base.BasePresenter;

import org.jetbrains.annotations.NotNull;

public class RecommendFragment2 extends BaseMvpFragment<ColumnData,RecommendContract2.IRecommendView, RecommendContract2.IRecommendPresenter> {

    @NotNull
    @Override
    public RecommendContract2.IRecommendPresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void onSuccess(ColumnData data, int requestType, int responseTye) {

    }

    @Override
    public void onFail(@NotNull String errorMsg, int responseTye) {

    }
}
