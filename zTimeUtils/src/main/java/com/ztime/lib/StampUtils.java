package com.ztime.lib;


import java.util.Calendar;
import java.util.Date;

public class StampUtils {

    /**
     * 判断是否为周末.
     *
     * @param stamp 日期时间戳
     * @return true为周末
     */
    public static boolean isWeekend(long stamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(stamp));
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
                || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }

    /**
     * 判断时间戳是否为0秒
     *
     * @param stamp 时间戳
     * @return 真
     */
    public static boolean isZeroSecond(long stamp) {
        Date date = new Date(stamp);
        return date.getSeconds() == 0;
    }

    /**
     * 判断是否为同一天
     *
     * @param time1 时间戳1
     * @param time2 时间戳2
     * @return boolean
     */
    public static boolean isSameDay(long time1, long time2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time1));
        int day1 = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.setTime(new Date(time2));
        int day2 = calendar.get(Calendar.DAY_OF_YEAR);
        return day1 == day2;
    }

    /**
     * 比较两个时间相差的秒数.
     *
     * @param startStamp    startStamp
     * @param endStamp  startStamp
     * @return  相差的秒数.
     */
    public static long secondsDifference(long startStamp, long endStamp) {
        return (endStamp - startStamp) / MillisPatternUnit.SEC_MILLIS;
    }

    /**
     * 比较给定时间和当前时间的差距s.
     *
     * @param stamp
     * @return
     */
    public static long secondsDifference(long stamp) {
        return (System.currentTimeMillis() - stamp) / MillisPatternUnit.SEC_MILLIS;
    }

    /**
     * 判断是否为同一月
     *
     * @param stamp1 时间戳1
     * @param stamp2 时间戳2
     * @return boolean
     */
    public static boolean isSameMonth(long stamp1, long stamp2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(stamp1));
        int month1 = calendar.get(Calendar.MONTH);
        calendar.setTime(new Date(stamp2));
        int month2 = calendar.get(Calendar.MONTH);
        return month1 == month2;
    }

    /**
     * 判断是否为同一年
     *
     * @param stamp1 时间戳1
     * @param stamp2 时间戳2
     * @return boolean
     */
    public static boolean isSameYear(long stamp1, long stamp2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(stamp1));
        int year1 = calendar.get(Calendar.YEAR);
        calendar.setTime(new Date(stamp2));
        int year2 = calendar.get(Calendar.YEAR);
        return year1 == year2;
    }

}
