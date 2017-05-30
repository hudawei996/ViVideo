package com.pinger.vivideo.utils;

import android.content.Context;
import android.content.Intent;

import com.pinger.vivideo.model.bean.VideoInfo;
import com.pinger.vivideo.ui.activitys.MainActivity;
import com.pinger.vivideo.ui.activitys.VideoInfoActivity;
import com.pinger.vivideo.ui.activitys.VideoListActivity;
import com.pinger.vivideo.ui.activitys.WelcomeActivity;

/**
 * Description: JumpUtil
 * Creator: yxc
 * date: 2016/9/21 14:46
 */
public class JumpUtil {

    public static void go2VideoInfoActivity(Context context, VideoInfo videoInfo) {
        Intent intent = new Intent(context, VideoInfoActivity.class);
        intent.putExtra("videoInfo", videoInfo);
        context.startActivity(intent);
    }

    public static void go2VideoListActivity(Context context, String catalogId, String title) {
        Intent intent = new Intent(context, VideoListActivity.class);
        intent.putExtra("catalogId", catalogId);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }
    public static void go2VideoListSearchActivity(Context context, String searchStr,String title) {
        Intent intent = new Intent(context, VideoListActivity.class);
        intent.putExtra("searchStr", searchStr);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }

    public static void go2MainActivity(Context context) {
        jump(context, MainActivity.class);
        ((WelcomeActivity) context).finish();
    }

    private static void jump(Context a, Class<?> clazz) {
        Intent intent = new Intent(a, clazz);
        a.startActivity(intent);
    }
}
