package com.example.hb_we.keap;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * Created by Cxy on 2017/5/8.
 */

public class Move_article1 extends Plan_MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.art1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // 隐藏状态栏
        Intent intent2=getIntent();
     }
}
