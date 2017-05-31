package com.pinger.vivideo.ui.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.pinger.vivideo.R;
import com.pinger.vivideo.component.ImageLoader;
import com.pinger.vivideo.utils.JumpUtil;

import butterknife.BindView;

public class WelcomeActivity extends Activity {

    @BindView(R.id.iv_welcome_bg)
    ImageView ivWelcomeBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ivWelcomeBg = (ImageView) findViewById(R.id.iv_welcome_bg);

        ImageLoader.load(this, getImgData(), ivWelcomeBg);
        ivWelcomeBg.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                jumpToMain();
            }
        }, 2000);

    }


    public void jumpToMain() {
        JumpUtil.go2MainActivity(this);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private String getImgData() {
        return "file:///android_asset/c.jpg";
    }
}