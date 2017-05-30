package com.pinger.vivideo.presenter.contract;


import com.pinger.vivideo.base.BasePresenter;
import com.pinger.vivideo.base.BaseView;
import com.pinger.vivideo.model.bean.VideoRes;

public interface VideoInfoContract {

    interface View extends BaseView<Presenter> {

        void showContent(VideoRes videoRes);

        boolean isActive();

        void hidLoading();

        void collected();

        void disCollect();
    }

    interface Presenter extends BasePresenter {
        void getDetailData(String dataId);

        void collect();

        void insertRecord();

    }
}
