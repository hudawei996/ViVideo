package com.pinger.vivideo.ui.activitys;

import android.os.Bundle;

import com.pinger.vivideo.R;
import com.pinger.vivideo.base.BaseActivity;
import com.pinger.vivideo.presenter.WelcomePresenter;
import com.pinger.vivideo.ui.view.WelcomeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.welcome_view)
    WelcomeView welcomeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        unbinder = ButterKnife.bind(this);
        mPresenter = new WelcomePresenter(welcomeView);
    }
}