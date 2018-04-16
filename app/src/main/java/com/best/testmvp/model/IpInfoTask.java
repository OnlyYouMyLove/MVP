package com.best.testmvp.model;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;

/**
 * Created by FuKaiqiang on 2018-04-14.
 */

public class IpInfoTask implements NetTask<String> {

    private IpInfoTask() {
    }

    public static IpInfoTask getInstance() {
        return SingletonHolder.sInstance;
    }

    private static class SingletonHolder {
        private static final IpInfoTask sInstance = new IpInfoTask();
    }

    @Override
    public void execute(final String url, final LoadTasksCallBack callBack) {

        HttpRequest.get(url, new BaseHttpRequestCallback<TitleData>() {
            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            protected void onSuccess(TitleData ipInfo) {
                super.onSuccess(ipInfo);
                callBack.onSuccess(ipInfo);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                callBack.onFinish();
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                callBack.onFailed();
            }
        });
    }
}
