package com.zxn.time;

import android.content.Context;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Calendar;

/**
 * Created by zxn on 2020/8/27.
 * 1: 周日,2: 周一,3: 周二,4: 周三,5: 周四,6: 周五,7: 周六,
 */
@IntDef({Calendar.SUNDAY,
        Calendar.MONDAY,
        Calendar.TUESDAY,
        Calendar.WEDNESDAY,
        Calendar.THURSDAY,
        Calendar.FRIDAY,
        Calendar.SATURDAY})
@Retention(RetentionPolicy.SOURCE)
@interface WeekDayType {

}
