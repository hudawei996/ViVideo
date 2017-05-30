package com.pinger.vivideo.presenter.contract;


import com.pinger.vivideo.base.BasePresenter;
import com.pinger.vivideo.base.BaseView;
import com.pinger.vivideo.model.bean.VideoRes;

/**
 * Description: ClassificationContract
 * Creator: yxc
 * date: 2016/9/21 17:55
 */
public interface ClassificationContract {

    interface View extends BaseView<Presenter> {

        boolean isActive();

        void showContent(VideoRes videoRes);

        void refreshFaild(String msg);
    }

    interface Presenter extends BasePresenter {
        void onRefresh();
    }
}
