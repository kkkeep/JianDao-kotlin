package com.jy.jiandao.home.recommend

import com.jy.jiandao.data.entity.ColumnData
import com.mr.k.mvp.base.*

/*
 * created by Cherry on 2020-01-08
 **/
class RecommendFragment : BaseMvpFragment2<ColumnData>(){



    override fun loadData() {
        super.loadData()

        mPresenter!!.getData(ParamsMap(""))
    }


    override fun getLayoutId(): Int {
        return 0
    }

    override fun onSuccess(data: ColumnData, requestType: Int, responseTye: Int) {

    }

    override fun onFail(errorMsg: String, responseTye: Int) {


    }


}