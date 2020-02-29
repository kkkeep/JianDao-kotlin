package com.jy.jiandao.home.recommend;

import com.jy.jiandao.data.entity.ColumnData;
import com.mr.k.mvp.base.IBaseMvpPresenter;
import com.mr.k.mvp.base.IBaseMvpView;

public interface RecommendContract2 {

    interface IRecommendView extends IBaseMvpView<ColumnData>{

    }

    interface IRecommendPresenter extends IBaseMvpPresenter<IRecommendView>{

    }

    interface IRecommendMode{

    }
}
