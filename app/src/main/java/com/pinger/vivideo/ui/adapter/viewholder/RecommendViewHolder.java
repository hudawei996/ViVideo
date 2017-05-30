package com.pinger.vivideo.ui.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.pinger.vivideo.R;
import com.pinger.vivideo.component.ImageLoader;
import com.pinger.vivideo.model.bean.VideoInfo;

/**
 * Description: RecommendViewHolder
 * Creator: yxc
 * date: 2016/9/21 9:53
 */

public class RecommendViewHolder extends BaseViewHolder<VideoInfo> {
    ImageView imgPicture;
    TextView tv_title;

    public RecommendViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_video);
        imgPicture = $(R.id.img_video);
        tv_title = $(R.id.tv_title);
        imgPicture.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override
    public void setData(VideoInfo data) {
        tv_title.setText(data.title);
        ImageLoader.load(getContext(),data.pic,imgPicture);
    }
}
