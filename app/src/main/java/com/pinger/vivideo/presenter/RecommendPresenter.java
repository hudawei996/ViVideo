package com.pinger.vivideo.presenter;

import android.support.annotation.NonNull;

import com.pinger.vivideo.base.RxPresenter;
import com.pinger.vivideo.model.bean.VideoRes;
import com.pinger.vivideo.model.net.RetrofitHelper;
import com.pinger.vivideo.model.net.VideoHttpResponse;
import com.pinger.vivideo.presenter.contract.RecommendContract;
import com.pinger.vivideo.utils.Preconditions;
import com.pinger.vivideo.utils.RxUtil;
import com.pinger.vivideo.utils.StringUtils;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Description: RecommendPresenter
 * Creator: yxc
 * date: 2016/9/21 16:26
 */
public class RecommendPresenter extends RxPresenter implements RecommendContract.Presenter {
    RecommendContract.View mView;
    int page = 0;

    public RecommendPresenter(@NonNull RecommendContract.View oneView) {
        mView = Preconditions.checkNotNull(oneView);
        mView.setPresenter(this);
    }

    @Override
    public void onRefresh() {
        page = 0;
        getPageHomeInfo();
    }

    private void getPageHomeInfo() {
        Subscription rxSubscription = RetrofitHelper.getVideoApi().getHomePage()
                .compose(RxUtil.<VideoHttpResponse<VideoRes>>rxSchedulerHelper())
                .compose(RxUtil.<VideoRes>handleResult())
                .subscribe(new Action1<VideoRes>() {
                    @Override
                    public void call(final VideoRes res) {
                        if (res != null) {
                            if (mView.isActive()) {
                                mView.showContent(res);
                            }
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.refreshFaild(StringUtils.getErrorMsg(throwable.getMessage()));
                    }
                });
        addSubscribe(rxSubscription);
    }

}
