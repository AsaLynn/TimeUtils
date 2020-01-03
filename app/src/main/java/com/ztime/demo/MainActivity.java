package com.ztime.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zxn.time.SDFPattern;
import com.zxn.time.TimeUtils;


public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ZTimeUtils.stampToDate(0, ZTimeUtils.FORMAT_TYPE_yMdHmS);

        String time = TimeUtils.timeToTime("20190403105532", SDFPattern.yyyyMMddHHmmss_SDF, SDFPattern.MMRdd_SDF);

        Log.i(TAG, "onCreate: -->" + time);

//        String time1 = ZTimeUtils.timeToTime("2019-04-03 10:55:32", SDFPattern.yyyyMMddHHmmSS_SDF_RRCC, SDFPattern.yyyySPMMSPdd_SDF);

//        Log.e(TAG, "onCreate: time1-->" + time1);
    }
}
