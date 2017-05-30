package com.pinger.vivideo.ui.activitys;

import android.os.Bundle;

import com.pinger.vivideo.R;
import com.pinger.vivideo.base.SwipeBackActivity;
import com.pinger.vivideo.presenter.CollectionPresenter;
import com.pinger.vivideo.ui.view.CollectionView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectionActivity extends SwipeBackActivity {

    @BindView(R.id.collect_view)
    CollectionView collectView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        unbinder = ButterKnife.bind(this);
        mPresenter = new CollectionPresenter(collectView, 0);
    }
}
