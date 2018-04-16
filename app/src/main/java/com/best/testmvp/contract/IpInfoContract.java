package com.best.testmvp.contract;

import com.best.testmvp.model.TitleData;
import com.best.testmvp.view.BaseView;

/**
 * Created by FuKaiqiang on 2018-04-15.
 */

public interface IpInfoContract {
    interface Presenter {
        void getIpInfo(String url);
    }

    interface View extends BaseView<Presenter> {
        void setIpInfo(TitleData ipData);

        void showLoading();

        void hideLoading();

        void showError();

        boolean isActivie();
    }
}
