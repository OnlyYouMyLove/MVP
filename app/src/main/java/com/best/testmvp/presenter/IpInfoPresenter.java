package com.best.testmvp.presenter;

import com.best.testmvp.contract.IpInfoContract;
import com.best.testmvp.model.TitleData;
import com.best.testmvp.model.LoadTasksCallBack;
import com.best.testmvp.model.NetTask;

/**
 * Created by FuKaiqiang on 2018-04-15.
 */

public class IpInfoPresenter implements IpInfoContract.Presenter, LoadTasksCallBack<TitleData> {

    private NetTask mNetTask;
    private IpInfoContract.View mAddTaskView;

    public IpInfoPresenter(NetTask netTask, IpInfoContract.View addTaskView) {
        mNetTask = netTask;
        mAddTaskView = addTaskView;
    }

    @Override
    public void onStart() {
        if (mAddTaskView.isActivie()) {
            mAddTaskView.showLoading();
        }
    }

    @Override
    public void onFinish() {
        if (mAddTaskView.isActivie()) {
            mAddTaskView.hideLoading();
        }
    }

    @Override
    public void onSuccess(TitleData ipInfo) {
        if (mAddTaskView.isActivie()) {
            mAddTaskView.setIpInfo(ipInfo);
        }
    }

    @Override
    public void onFailed() {
        if (mAddTaskView.isActivie()) {
            mAddTaskView.showError();
            mAddTaskView.hideLoading();
        }
    }

    @Override
    public void getIpInfo(String ip) {
        mNetTask.execute(ip, this);
    }
}
