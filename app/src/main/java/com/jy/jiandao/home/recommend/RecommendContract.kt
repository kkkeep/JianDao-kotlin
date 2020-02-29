package com.jy.jiandao.home.recommend

import com.jy.jiandao.data.entity.ColumnData
import com.mr.k.mvp.base.IBaseMvpPresenter
import com.mr.k.mvp.base.IBaseMvpView

/*
 * created by Cherry on 2020-01-08
 **/
interface RecommendContract {
    interface IRecommendView : IBaseMvpView<ColumnData>

    interface IRecommendPresenter : IBaseMvpPresenter<IRecommendView>

    interface IRecommendMode
}