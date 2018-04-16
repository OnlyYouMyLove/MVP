package com.best.testmvp.model;

/**
 * Created by FuKaiqiang on 2018-04-14.
 */

public interface LoadTasksCallBack<T> {

    void onStart();

    void onFinish();

    void onSuccess(T t);

    void onFailed();

}
