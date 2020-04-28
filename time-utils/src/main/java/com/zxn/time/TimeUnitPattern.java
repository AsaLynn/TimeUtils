package com.zxn.time;

/**
 * TimeUnitType
 * int HOUR_TEXT = 30;
 * <p>
 * int HOUR_NUM = 30;
 * Created by zxn on 2020/4/28.
 */
public interface TimeUnitPattern {

    /**
     * 毫秒值
     */
    int MILLISECOND = 0;

    /**
     * 1秒1000毫秒
     */
    int SECOND = 1;

    /**
     * 输出格式,最大单位秒
     */
    int SECOND_TEXT = 1;

    /**
     * 1分钟60秒
     */
    int MINUTE = 2;

    /**
     * 输出格式,最大单位分钟
     */
    int MINUTE_TEXT = 20;

    /**
     * 一小时60分钟
     */
    int HOUR = 3;

    /**
     * 输出格式,最大单位小时
     */
    int HOUR_TEXT = 30;


    /**
     * 一天24小时
     */
    int DAY = 4;

    /**
     * 输出格式,最大单位天
     */
    int DAY_TEXT = 4;

    /**
     * 一周7天
     */
    int WEEK = 5;

    /**
     * 一个月30天
     */
    int MONTH = 6;

    /**
     * 一年365天
     */
    int YEAR = 7;


}
