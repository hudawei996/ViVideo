package com.pinger.vivideo.ui.fragments;

import android.view.LayoutInflater;

import com.pinger.vivideo.R;
import com.pinger.vivideo.base.BaseFragment;
import com.pinger.vivideo.presenter.ClassificationPresenter;
import com.pinger.vivideo.ui.view.ClassificationView;

import butterknife.BindView;

/**
 * Description: ClassificationFragment
 * Creator: yxc
 * date: 2016/9/21 17:45
 */
public class ClassificationFragment extends BaseFragment {

    @BindView(R.id.two_view)
    ClassificationView twoView;

    @Override
    protected int getLayout() {
        return R.layout.fragment_classification;
    }

    @Override
    protected void initView(LayoutInflater inflater) {
        mPresenter = new ClassificationPresenter(twoView);
    }

    @Override
    protected void lazyFetchData() {
        ((ClassificationPresenter) mPresenter).onRefresh();
    }
}
