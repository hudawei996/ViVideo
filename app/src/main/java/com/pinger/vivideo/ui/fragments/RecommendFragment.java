package com.pinger.vivideo.ui.fragments;

import android.view.LayoutInflater;

import com.pinger.vivideo.R;
import com.pinger.vivideo.base.BaseFragment;
import com.pinger.vivideo.presenter.RecommendPresenter;
import com.pinger.vivideo.ui.view.RecommendView;

import butterknife.BindView;

/**
 * Description: 精选
 * Creator: yxc
 * date: $date $time
 */
public class RecommendFragment extends BaseFragment {

    @BindView(R.id.one_view)
    RecommendView oneView;

    @Override
    protected int getLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView(LayoutInflater inflater) {
        mPresenter = new RecommendPresenter(oneView);
    }

    @Override
    protected void lazyFetchData() {
        ((RecommendPresenter) mPresenter).onRefresh();
    }

    @Override
    public void onResume() {
        super.onResume();
        oneView.stopBanner(false);
    }

    @Override
    public void onPause() {
        super.onPause();
        oneView.stopBanner(true);
    }
}
