package com.ztime.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ztime.lib.ZTimeUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ZTimeUtils.stampToDate(0,ZTimeUtils.FORMAT_TYPE_yMdHmS);
    }
}
