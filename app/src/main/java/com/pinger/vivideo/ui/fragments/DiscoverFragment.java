package com.pinger.vivideo.ui.fragments;

import android.view.LayoutInflater;

import com.pinger.vivideo.R;
import com.pinger.vivideo.base.BaseFragment;
import com.pinger.vivideo.presenter.DiscoverPresenter;
import com.pinger.vivideo.ui.view.DiscoverView;

import butterknife.BindView;

/**
 * author: Pinger
 * Creator: yxc
 * date: $date $time
 */
public class DiscoverFragment extends BaseFragment {

    @BindView(R.id.three_view)
    DiscoverView threeView;

    @Override
    protected int getLayout() {
        return R.layout.fragment_discover;
    }

    @Override
    protected void initView(LayoutInflater inflater) {
        mPresenter = new DiscoverPresenter(threeView);
    }

    @Override
    protected void lazyFetchData() {
        ((DiscoverPresenter) mPresenter).getData();
    }
}
