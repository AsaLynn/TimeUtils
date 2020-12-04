package com.ztime.demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zxn.time.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        ZTimeUtils.stampToDate(0, ZTimeUtils.FORMAT_TYPE_yMdHmS);
        val time = TimeUtils.timeToTime("20190403105532", SDFPattern.yyyyMMddHHmmss_SDF, SDFPattern.MMdd_SDF_R)
        Log.i(TAG, "onCreate: -->$time")

//        String time1 = ZTimeUtils.timeToTime("2019-04-03 10:55:32", SDFPattern.yyyyMMddHHmmSS_SDF_RRCC, SDFPattern.yyyySPMMSPdd_SDF);

//        Log.e(TAG, "onCreate: time1-->" + time1);

        showTime()

        tvTime.setOnClickListener {
            showTime()
        }
    }

    private fun showTime() {
        //val startTime = 1607068800000
        val startTime = 1606000000000
        val currentTimeMillis = System.currentTimeMillis()
        //1607074248520 - 1607068800000
        Log.i(TAG, "showTime:currentTimeMillis--> $currentTimeMillis")
        val l = currentTimeMillis - startTime
        Log.i(TAG, "showTime:l--> $l")//5504583/
        Log.i(TAG, "showTime:MillisPatternUnit.DAY_MILLIS--> ${MillisPatternUnit.DAY_MILLIS}")// (5504583/86400000)
        val abs = abs(l / MillisPatternUnit.DAY_MILLIS.toDouble())
        Log.i(TAG, "showTime:abs--> $abs")
        val howLong = StampUtils.howLong(startTime, TimeUnitPattern.DAY, DecimalFormat("0.000000"))
        Log.e(TAG, "onCreate: howLong-->$howLong")
        tvTime.text = "$howLong(天)"
    }
}