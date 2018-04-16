package com.best.testmvp.view;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.best.testmvp.model.IpInfoTask;
import com.best.testmvp.R;
import com.best.testmvp.presenter.IpInfoPresenter;
import com.best.testmvp.util.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    private IpInfoPresenter ipInfoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  把Fragment添加到Activity中
        IpInfoFragment ipInfoFragment = (IpInfoFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (ipInfoFragment == null) {
            ipInfoFragment = IpInfoFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), ipInfoFragment, R.id.contentFrame);
        }
        //  把Model和View注入Presenter,并且把Presenter注入Fragment
        IpInfoTask ipInfoTask = IpInfoTask.getInstance();
        ipInfoPresenter = new IpInfoPresenter(ipInfoTask, ipInfoFragment);
        ipInfoFragment.setPresenter(ipInfoPresenter);
    }
}
