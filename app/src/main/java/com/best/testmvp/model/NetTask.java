package com.best.testmvp.model;

/**
 * Created by FuKaiqiang on 2018-04-14.
 */

public interface NetTask<T> {
    void execute(T data,LoadTasksCallBack callBack);
}
