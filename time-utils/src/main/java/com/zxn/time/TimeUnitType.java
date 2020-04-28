package com.zxn.time;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 目前支持:毫秒,秒,分,时,天,周,月,年.
 * Created by zxn on 2020/4/28.
 */
@IntDef({TimeUnitPattern.MILLISECOND,
        TimeUnitPattern.SECOND,
        TimeUnitPattern.MINUTE,
        TimeUnitPattern.HOUR,
        TimeUnitPattern.DAY,
        TimeUnitPattern.WEEK,
        TimeUnitPattern.MONTH,
        TimeUnitPattern.YEAR,})
@Retention(RetentionPolicy.SOURCE)
public @interface TimeUnitType {
}
