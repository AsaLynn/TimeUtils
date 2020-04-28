package com.zxn.time;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by zxn on 2020/4/28.
 */

@IntDef({TimeUnitPattern.SECOND_TEXT,
        TimeUnitPattern.MINUTE_TEXT,
        TimeUnitPattern.HOUR_TEXT,
        TimeUnitPattern.DAY_TEXT})
@Retention(RetentionPolicy.SOURCE)
public @interface ShowUnitType {
}
