package com.jy.jiandao;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.jy.jiandao.data.HttpResult;
import com.jy.jiandao.data.ok.ApiService;
import com.jy.jiandao.data.ok.converter.MyGsonConverterFactory;
import com.mr.k.mvp.MvpManager;
import com.mr.k.mvp.oknet.NetConfig;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

/*
 * created by Cherry on 2019-12-26
 **/
public class JDApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
      //  DataService.init(ApiService.class, AppConstant.BASE_URL, MyGsonConverterFactory.create());





        NetConfig netConfig = new NetConfig( AppConstant.BASE_URL);

        netConfig.setHttpData(HttpResult.class);

        netConfig.setAppApiService(ApiService.class);

        netConfig.setFactory(MyGsonConverterFactory.create());

        MvpManager.INSTANCE.initMvp(this,netConfig);



        initRefreshLayout();

    }
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    private void initRefreshLayout() {

        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {//设置全局的Header构建器
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                return new ClassicsHeader(context)
                        .setDrawableSize(14)
                        .setTextSizeTitle(12)
                        .setAccentColor(0xffb5b5b5)//文字提示颜色
                        .setPrimaryColor(0xfffafafa)//全局设置主题颜色
                        .setEnableLastTime(false);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });

        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() { //设置全局的Footer构建器
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                return new ClassicsFooter(context) //指定为经典Footer，默认是 BallPulseFooter
                        .setDrawableSize(14)
                        .setTextSizeTitle(12)
                        .setAccentColor(0xffb5b5b5)//文字提示颜色
                        .setPrimaryColor(0xfffafafa);//全局设置主题颜色
            }
        });
    }

}
