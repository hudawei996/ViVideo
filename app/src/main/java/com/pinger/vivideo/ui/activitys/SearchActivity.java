package com.pinger.vivideo.ui.activitys;

import com.pinger.vivideo.R;
import com.pinger.vivideo.base.NewSwipeBackActivity;
import com.pinger.vivideo.model.bean.VideoInfo;
import com.pinger.vivideo.presenter.SearchVideoListPresenter;
import com.pinger.vivideo.ui.view.SearchVideoListView;

import java.util.List;

import butterknife.BindView;

public class SearchActivity extends NewSwipeBackActivity {

    @BindView(R.id.search_video_info_view)
    SearchVideoListView searchVideoListView;
    List<VideoInfo> list;

    @Override
    protected int setLayoutResourceID() {
        return R.layout.activity_search;
    }

    @Override
    protected void onBaseCreate() {
        getIntentData();
        mPresenter = new SearchVideoListPresenter(searchVideoListView,list);
    }

    private void getIntentData() {
        list = (List<VideoInfo>) getIntent().getSerializableExtra("recommend");
    }
}