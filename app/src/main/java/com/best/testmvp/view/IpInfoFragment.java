package com.best.testmvp.view;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.best.testmvp.R;
import com.best.testmvp.contract.IpInfoContract;
import com.best.testmvp.model.TitleData;

import java.util.List;

/**
 * Created by FuKaiqiang on 2018-04-15.
 */

public class IpInfoFragment extends Fragment implements IpInfoContract.View {

    private Button mBt_ipinfo;
    private TextView mNews;
    private ProgressDialog mProgressDialog;

    private IpInfoContract.Presenter mPresenter;


    private static final String URL = "http://v.juhe.cn/toutiao/index?type=top&key=cc651913ae067cf88c7d9ec710fe5b3a";

    public static IpInfoFragment newInstance() {
        return new IpInfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ipinfo, container, false);
        mNews = (TextView) root.findViewById(R.id.tv_news);
        mBt_ipinfo = (Button) root.findViewById(R.id.bt_ipinfo);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setTitle("获取数据中");
        mBt_ipinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getIpInfo(URL);
            }
        });
    }

    @Override
    public void setPresenter(IpInfoContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setIpInfo(TitleData ipInfo) {
        if (ipInfo != null && ipInfo.getResult().getData() != null) {
            List<TitleData.ResultBean.DataBean> data = ipInfo.getResult().getData();
            mNews.setText(data.get(0).getTitle());
        }
    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void showError() {
        Toast.makeText(getActivity(), "网络出错", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isActivie() {
        return isAdded();
    }
}
