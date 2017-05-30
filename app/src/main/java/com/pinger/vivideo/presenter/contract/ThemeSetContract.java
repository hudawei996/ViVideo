package com.pinger.vivideo.presenter.contract;


import com.pinger.vivideo.base.BasePresenter;
import com.pinger.vivideo.base.BaseView;
import com.pinger.vivideo.model.bean.VideoType;

import java.util.List;

/**
 * Description: ThemeSetContract
 * Creator: cp
 * date: 2016/9/29 12:06
 */
public interface ThemeSetContract {

    interface View extends BaseView<Presenter> {

        boolean isActive();

        void showContent(List<VideoType> list);

    }

    interface Presenter extends BasePresenter {

        void getThemeData();

    }
}
