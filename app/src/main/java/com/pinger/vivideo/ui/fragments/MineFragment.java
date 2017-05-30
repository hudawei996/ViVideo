package com.pinger.vivideo.ui.fragments;

import android.view.LayoutInflater;

import com.pinger.vivideo.R;
import com.pinger.vivideo.base.BaseFragment;
import com.pinger.vivideo.presenter.MinePresenter;
import com.pinger.vivideo.ui.view.MineView;

import butterknife.BindView;

/**
 * Description:
 * Creator: yxc
 * date: $date $time
 */
public class MineFragment extends BaseFragment {
    public static final String SET_THEME = "SET_THEME";
    @BindView(R.id.mine_view)
    MineView mineView;

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(LayoutInflater inflater) {
        super.initView(inflater);
        mPresenter = new MinePresenter(mineView);
    }
}
