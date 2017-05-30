package com.pinger.vivideo.presenter;

import android.support.annotation.NonNull;

import com.pinger.vivideo.base.RxPresenter;
import com.pinger.vivideo.model.bean.VideoInfo;
import com.pinger.vivideo.model.bean.VideoRes;
import com.pinger.vivideo.model.net.RetrofitHelper;
import com.pinger.vivideo.model.net.VideoHttpResponse;
import com.pinger.vivideo.presenter.contract.SearchVideoListContract;
import com.pinger.vivideo.utils.Preconditions;
import com.pinger.vivideo.utils.RxUtil;
import com.pinger.vivideo.utils.StringUtils;

import java.util.List;

import rx.Subscription;
import rx.functions.Action1;

public class SearchVideoListPresenter extends RxPresenter implements SearchVideoListContract.Presenter {
    @NonNull
    final SearchVideoListContract.View mView;
    int page = 1;

    String searchStr = "";


    public SearchVideoListPresenter(@NonNull SearchVideoListContract.View addTaskView, List<VideoInfo> list) {
        mView = Preconditions.checkNotNull(addTaskView);
        mView.setPresenter(this);
        mView.showRecommend(list);
    }

    @Override
    public void onRefresh() {
        page = 1;
        if (searchStr != null && !searchStr.equals("")) {
            getSearchVideoList(searchStr);
        }
    }

    @Override
    public void loadMore() {
        page++;
        if (searchStr != null && !searchStr.equals("")) {
            getSearchVideoList(searchStr);
        }
    }

    @Override
    public void setSearchKey(String strSearchKey) {
        this.searchStr = strSearchKey;
    }

    /**
     * 搜索电影
     *
     * @param searchStr
     */
    private void getSearchVideoList(String searchStr) {
        Subscription rxSubscription = RetrofitHelper.getVideoApi().getVideoListByKeyWord(searchStr, page + "")
                .compose(RxUtil.<VideoHttpResponse<VideoRes>>rxSchedulerHelper())
                .compose(RxUtil.<VideoRes>handleResult())
                .subscribe(new Action1<VideoRes>() {
                    @Override
                    public void call(VideoRes res) {
                        if (res != null) {
                            if (mView.isActive()) {
                                if (page == 1) {
                                    mView.showContent(res.list);
                                } else {
                                    mView.showMoreContent(res.list);
                                }
                            }
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        if (page > 1) {
                            page--;
                        }
                        mView.refreshFaild(StringUtils.getErrorMsg(throwable.getMessage()));
                    }
                });
        addSubscribe(rxSubscription);
    }


}
