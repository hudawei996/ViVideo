package com.pinger.vivideo.presenter.contract;


import com.pinger.vivideo.base.BasePresenter;
import com.pinger.vivideo.base.BaseView;
import com.pinger.vivideo.model.bean.VideoType;

import java.util.List;

/**
 * Description: VideoListContract
 * Creator: yxc
 * date: 2016/9/21 14:59
 */
public interface VideoListContract {

    interface View extends BaseView<Presenter> {

        boolean isActive();

        void showTitle(String title);

        void refreshFaild(String msg);

        void loadMoreFaild(String msg);

        void showContent(List<VideoType> list);

        void showMoreContent(List<VideoType> list);
    }

    interface Presenter extends BasePresenter {

        void onRefresh();

        void loadMore();

    }
}
