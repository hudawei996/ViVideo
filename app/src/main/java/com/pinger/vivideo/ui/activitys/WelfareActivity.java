package com.pinger.vivideo.ui.activitys;

import android.os.Bundle;

import com.pinger.vivideo.R;
import com.pinger.vivideo.base.SwipeBackActivity;
import com.pinger.vivideo.presenter.WelfarePresenter;
import com.pinger.vivideo.ui.view.WelfareView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelfareActivity extends SwipeBackActivity {

    @BindView(R.id.welfare_view)
    WelfareView welfareView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welfare);
        unbinder = ButterKnife.bind(this);
        mPresenter = new WelfarePresenter(welfareView);
    }

}
