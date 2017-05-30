package com.pinger.vivideo.presenter.contract;


import com.pinger.vivideo.base.BasePresenter;
import com.pinger.vivideo.base.BaseView;

import java.util.List;

/**
 * Description: WelcomeContract
 * Creator: yxc
 * date: 2016/9/22 13:16
 */
public interface WelcomeContract {

    interface View extends BaseView<Presenter> {

        boolean isActive();

        void showContent(List<String> list);

        void jumpToMain();
    }

    interface Presenter extends BasePresenter {
        void getWelcomeData();
    }
}
