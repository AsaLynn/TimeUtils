package com.ztime.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ztime.lib.SDFPattern;
import com.ztime.lib.ZTimeUtils;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ZTimeUtils.stampToDate(0, ZTimeUtils.FORMAT_TYPE_yMdHmS);

        String time = ZTimeUtils.timeToTime("20190403105532", SDFPattern.yyyyMMddHHmmss_SDF, SDFPattern.MMRdd_SDF);

        Log.i(TAG, "onCreate: -->" + time);
    }
}
