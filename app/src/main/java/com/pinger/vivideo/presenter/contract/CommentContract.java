package com.pinger.vivideo.presenter.contract;


import com.pinger.vivideo.base.BasePresenter;
import com.pinger.vivideo.base.BaseView;
import com.pinger.vivideo.model.bean.VideoType;

import java.util.List;

/**
 * Description: CommentContract
 * Creator: yxc
 * date: 2016/10/18 13:21
 */
public interface CommentContract {

    interface View extends BaseView<Presenter> {

        boolean isActive();

        void refreshFaild(String msg);

        void showContent(List<VideoType> list);

        void showMoreContent(List<VideoType> list);
    }

    interface Presenter extends BasePresenter {

        void onRefresh();

        void loadMore();

        void setMediaId(String id);

    }
}
