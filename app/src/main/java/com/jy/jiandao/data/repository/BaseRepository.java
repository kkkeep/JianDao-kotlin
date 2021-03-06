package com.jy.jiandao.data.repository;

import com.google.gson.Gson;
import com.jy.jiandao.AppConstant;
import com.jy.jiandao.data.HttpResult;
import com.jy.jiandao.data.ok.JDDataService;
import com.mr.k.mvp.Utils.DataFileCacheUtils;
import com.mr.k.mvp.base.IBaseCallBack;
import com.mr.k.mvp.exception.ResultException;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.RxActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/*
 * created by Cherry on 2020-01-03
 **/
public class BaseRepository {


    public <T> void get(LifecycleProvider provider, Map<String, String> params, String url, IBaseCallBack<T> baseCallBack) {
        get(provider, null, params, url, baseCallBack);


    }

    public <T> void get(LifecycleProvider provider, Consumer<T> consumer, Map<String, String> params, String url, IBaseCallBack<T> baseCallBack) {


        Observable<T> observable = JDDataService.getApiService().get(AppConstant.Url.GET_TOPIC_NEWS, params)
                .map(s -> {
                    Type[] types = baseCallBack.getClass().getGenericInterfaces();

                    ParameterizedType pType = (ParameterizedType) types[0];


                    DataFileCacheUtils.ParameterizedTypeImpl parameterizedType = new DataFileCacheUtils.ParameterizedTypeImpl(HttpResult.class, pType.getActualTypeArguments());

                    Gson gson = new Gson();

                    return gson.<HttpResult<T>>fromJson(s, parameterizedType);
                })
                .flatMap(this::getConvertObservable).observeOn(AndroidSchedulers.mainThread());


        if (consumer != null) {
            observable = observable.doOnNext(consumer);
        }


        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(provider instanceof RxActivity ? (((RxActivity) provider).bindUntilEvent(ActivityEvent.DESTROY)) : ((RxFragment) provider).bindUntilEvent(FragmentEvent.DESTROY_VIEW))
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(T d) {
                        baseCallBack.onSuccess(d);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof ResultException) {
                            baseCallBack.onFail((ResultException) e);
                        } else {
                            baseCallBack.onFail(new ResultException(e));
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    public <D> void observer(LifecycleProvider provider, Observable<HttpResult<D>> observable, Function<HttpResult<D>, ObservableSource<D>> function, IBaseCallBack<D> callBack) {

        LifecycleTransformer<D> transformer;
        if (provider instanceof RxActivity) {
            transformer = (((RxActivity) provider).bindUntilEvent(ActivityEvent.DESTROY));
        } else {
            transformer = ((RxFragment) provider).bindUntilEvent(FragmentEvent.DESTROY_VIEW);
        }


        observable
                .flatMap(function)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(transformer)
                .subscribe(new Observer<D>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(D d) {
                        callBack.onSuccess(d);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof ResultException) {
                            callBack.onFail((ResultException) e);
                        } else {
                            callBack.onFail(new ResultException(e));
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public <D> void observer(LifecycleProvider provider, Observable<HttpResult<D>> observable, Function<HttpResult<D>, ObservableSource<D>> function, Consumer<D> consumer, IBaseCallBack<D> callBack) {

        LifecycleTransformer<D> transformer;
        if (provider instanceof RxActivity) {
            transformer = (((RxActivity) provider).bindUntilEvent(ActivityEvent.DESTROY));
        } else {
            transformer = ((RxFragment) provider).bindUntilEvent(FragmentEvent.DESTROY_VIEW);
        }


        Observable<D> observable1 = observable.flatMap(function);

        if (consumer != null) {
            observable1 = observable1.doOnNext(consumer);
        }

        observable1.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(transformer)
                .subscribe(new Observer<D>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(D d) {
                        callBack.onSuccess(d);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (e instanceof ResultException) {
                            callBack.onFail((ResultException) e);
                        } else {
                            callBack.onFail(new ResultException(e));
                        }
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public <D> Observable<D> getConvertObservable(HttpResult<D> httpResult) {
        if (httpResult.code == 1) {
            if (httpResult.data != null) {
                return Observable.just(httpResult.data);
            } else {
                return Observable.error(new ResultException(ResultException.SERVER_ERROR));
            }
        } else {
            return Observable.error(new ResultException(httpResult.message));
        }
    }
}
