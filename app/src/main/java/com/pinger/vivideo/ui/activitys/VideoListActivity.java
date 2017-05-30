package com.pinger.vivideo.ui.activitys;

import com.pinger.vivideo.R;
import com.pinger.vivideo.base.NewSwipeBackActivity;
import com.pinger.vivideo.presenter.VideoListPresenter;
import com.pinger.vivideo.ui.view.VideoListView;

import butterknife.BindView;

public class VideoListActivity extends NewSwipeBackActivity {

    String mTitle = "";
    String mCatalogId = "";
    @BindView(R.id.video_list_view)
    VideoListView videlListView;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_video_list);
//        unbinder = ButterKnife.bind(this);
//
//    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_video_list;
    }

    @Override
    protected void onBaseCreate() {
        getIntentData();
        mPresenter = new VideoListPresenter(videlListView, mCatalogId);
    }

    private void getIntentData() {
        mCatalogId = getIntent().getStringExtra("catalogId");
        mTitle = getIntent().getStringExtra("title");
        videlListView.setTitleName(mTitle);
    }
}
