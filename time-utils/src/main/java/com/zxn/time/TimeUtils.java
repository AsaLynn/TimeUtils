package com.zxn.time;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 * 时间工具类--SDFPattern
 * DateUtils...
 * Updated by zxn on 2020/8/24.
 * Created by zxn on 2019/02/19.
 */
public class TimeUtils {

    @SuppressLint("SimpleDateFormat")
    private static final SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat();

    private static final int TIME_UNIT_SECOND = 1;
    private static final int TIME_UNIT_MINUTIUE = TIME_UNIT_SECOND * 60;//分钟
    private static final int TIME_UNIT_HOUR = TIME_UNIT_MINUTIUE * 60;//小时

    private static final int TIME_UNIT_DAY = TIME_UNIT_HOUR * 24;//天

    Long gg = 1000 * 60l, mmax = gg * 60, hmax = mmax * 24, dmax = hmax * 30;

    /**
     * 通过年份和月份 得到当月的总天数
     *
     * @param year  年份
     * @param month 月份
     * @return 该月总天数
     */
    public static int getMonthDays(int year, int month) {
        month++;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;
        }
    }

    /**
     * 返回当前月份1号位于周几
     *
     * @param year  年份
     * @param month 月份，传入系统获取的，不需要正常的
     * @return 一：1		二：2		三：3		四：4		五：5		六：6         日：7
     */
    public static int getFirstDayWeek17(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, 1);
        Log.d("DateView", "DateView:First:" + calendar.getFirstDayOfWeek());
        int c = calendar.get(Calendar.DAY_OF_WEEK);
        c--;
        if (c == 0) c = 7;
        return c;
    }

    /**
     * 使用Calendar,根据日期推算获取周名称
     *
     * @param year  年份
     * @param month 月份
     * @param day   日期
     * @return 周名成
     */
    public static String getDayWeek(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        Log.d("DateView", "DateView:First:" + calendar.getFirstDayOfWeek());
        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                return "周日";
            case 2:
                return "周一";
            case 3:
                return "周二";
            case 4:
                return "周三";
            case 5:
                return "周四";
            case 6:
                return "周五";
            case 7:
                return "周六";
            default:
                return "";
        }
    }

    public static int getYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public static int getMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH) + 1;
    }

    /**
     * 数字转月份
     *
     * @param month 月份数字
     * @return 月份名字
     */
    public static String monthNumToMonthName(String month) {
        String m = month;
        if ("1".equals(month)) {
            m = "一月份";
        } else if ("2".equals(month)) {
            m = "二月份";
        } else if ("3".equals(month)) {
            m = "三月份";
        } else if ("4".equals(month)) {
            m = "四月份";
        } else if ("5".equals(month)) {
            m = "五月份";
        } else if ("6".equals(month)) {
            m = "六月份";
        } else if ("7".equals(month)) {
            m = "七月份";
        } else if ("8".equals(month)) {
            m = "八月份";
        } else if ("9".equals(month)) {
            m = "九月份";
        } else if ("10".equals(month)) {
            m = "十月份";
        } else if ("11".equals(month)) {
            m = "十一月份";
        } else if ("12".equals(month)) {
            m = "十二月份";
        }
        return m;
    }

    /**
     * 使用Calendar判断指定的时间是否为过去的时间
     *
     * @param year  年份
     * @param month 月份
     * @param date  日期
     * @return true:相比现在属于过去的时间
     */
    public static boolean isPast(int year, int month, int date) {
        long inTime = getTimeInMillis(year, month, date);
        return inTime <= System.currentTimeMillis();
    }

    /**
     * 使用Calendar获取指定日期的时间戳
     *
     * @param year  年份
     * @param month 月份
     * @param date  日期
     * @return 指定日期的时间戳
     */
    public static long getTimeInMillis(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        return calendar.getTimeInMillis();
    }

    /**
     * 将指定单位的时间值,转化为x小时x分钟,
     *
     * @param count         原时间值的数量.
     * @param inputUnitType 原时间值的单位.
     * @param outUnitType   最终时间值的单位.
     * @return 格式为:x小时x分钟的时长.
     */
    public static String formatDuration(int count, @TimeUnitType int inputUnitType, @ShowUnitType int outUnitType) {
        if (inputUnitType == TimeUnitPattern.MILLISECOND) {

        } else if (inputUnitType == TimeUnitPattern.SECOND) {
            int totalMillis = count * MillisPatternUnit.SEC_MILLIS;
            int h = totalMillis / MillisPatternUnit.HOUR_MILLIS;
            int m = (totalMillis % MillisPatternUnit.HOUR_MILLIS / MillisPatternUnit.MIN_MILLIS);
            int s = (totalMillis % MillisPatternUnit.HOUR_MILLIS % MillisPatternUnit.MIN_MILLIS / MillisPatternUnit.SEC_MILLIS);
            if (outUnitType == TimeUnitPattern.SECOND_TEXT) {

            } else if (outUnitType == TimeUnitPattern.MINUTE_TEXT) {

            } else if (outUnitType == TimeUnitPattern.HOUR_TEXT) {
                return h + "小时" + m + "分钟" + s + "秒";
            } else if (outUnitType == TimeUnitPattern.DAY_TEXT) {

            }
        } else if (inputUnitType == TimeUnitPattern.MINUTE) {
            int totalMillis = count * MillisPatternUnit.MIN_MILLIS;
            int h = totalMillis / MillisPatternUnit.HOUR_MILLIS;
            int m = (totalMillis % MillisPatternUnit.HOUR_MILLIS / MillisPatternUnit.MIN_MILLIS);
            if (outUnitType == TimeUnitPattern.SECOND_TEXT) {

            } else if (outUnitType == TimeUnitPattern.MINUTE_TEXT) {

            } else if (outUnitType == TimeUnitPattern.HOUR_TEXT) {
                return h + "小时" + m + "分钟";
            } else if (outUnitType == TimeUnitPattern.DAY_TEXT) {

            }
        } else if (inputUnitType == TimeUnitPattern.HOUR) {

        } else if (inputUnitType == TimeUnitPattern.DAY) {

        } else if (inputUnitType == TimeUnitPattern.WEEK) {

        } else if (inputUnitType == TimeUnitPattern.MONTH) {//月按30天

        } else if (inputUnitType == TimeUnitPattern.YEAR) {

        }
        return "";
    }


    /**
     * 将给定的时间设置时,分
     *
     * @param hour    小时
     * @param minute  分钟
     * @param pattern 时间格式
     * @return 指定格式的时间.
     */
    public static String changeTime(String time, @PatternType String pattern, int hour, int minute) {
        Calendar calendar = Calendar.getInstance();
        long stamp = timeToStamp(time, pattern);
        calendar.setTimeInMillis(stamp);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        mSimpleDateFormat.applyPattern(pattern);
        return mSimpleDateFormat.format(calendar.getTime());
    }

    /**
     * 使用Calendar获取指定时间格式.
     *
     * @param year    年份
     * @param month   月份
     * @param date    日期
     * @param pattern 时间格式
     * @return 指定格式的时间.
     */
    public static String getTimeByCalendar(int year, int month, int date, @PatternType String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        mSimpleDateFormat.applyPattern(pattern);
        return mSimpleDateFormat.format(calendar.getTime());
    }

    /***
     * 根据当前时间推算dayCount天前或dayCount天后的时间.
     * @param dayCount  相差的天数.
     * @return 推算dayCount天前或dayCount天后的时间.
     * @param pattern 格式
     */
    @Deprecated
    public static String calculateTime(int dayCount, @PatternType String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + dayCount);
        mSimpleDateFormat.applyPattern(pattern);
        return mSimpleDateFormat.format(calendar.getTime());
    }

    /**
     * 根据指定时间推算dayCount天前或dayCount天后的时间.
     *
     * @param dayCount 相差的天数.
     * @param date     date
     * @param pattern  pattern
     * @return 推算dayCount天前或dayCount天后的时间.
     */
    public static String calculateTime(int dayCount, String date, @PatternType String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(timeToStamp(date, pattern)));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + dayCount);
        mSimpleDateFormat.applyPattern(pattern);
        return mSimpleDateFormat.format(calendar.getTime());
    }

    /**
     * 获取当前时间.
     *
     * @param pattern 格式
     * @return 当前时间
     */
    public static String currentTime(@PatternType String pattern) {
        mSimpleDateFormat.applyPattern(pattern);
        return mSimpleDateFormat.format(new Date(System.currentTimeMillis()));
    }

    /**
     * 时间格式转化,老格式转新格式.
     *
     * @param time       老格式的时间
     * @param oldPattern 老格式
     * @param newPattern 新格式
     * @return 新格式的时间
     */
    public static String timeToTime(String time, @PatternType String oldPattern, @PatternType String newPattern) {
        long stamp = timeToStamp(time, oldPattern);
        return stampToTime(stamp, newPattern);
    }


    /**
     * 获取当前时间是上午还是下午:afternoon,midday,morning
     *
     * @return AM, PM
     */
    public static String getCurrentTimeType() {
        long time = System.currentTimeMillis();
        final Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(time);
        int apm = mCalendar.get(Calendar.AM_PM);
        if (apm == 0) {
            return "AM";
        } else {
            return "PM";
        }
    }

    /**
     * 判断时间戳是否为0分
     *
     * @param stamp 时间戳
     * @return 真
     */
    public static boolean isZeroMinute(long stamp) {
        Date date = new Date(stamp);
        int minutes = date.getMinutes();
        return minutes == 0;
    }

    /**
     * 判断时间戳是否为0点0分0秒
     *
     * @param stamp 时间戳
     * @return 真
     */
    public static boolean isZeroTime(long stamp) {
        Date date = new Date(stamp);
        int hours = date.getHours();
        int minutes = date.getMinutes();
        int seconds = date.getSeconds();
        return hours == 0 && minutes == 0 && seconds == 0;
    }

    /**
     * 将时间戳转换为日期字符串,方法有待完善.
     *
     * @param time        时间戳
     * @param patternType 格式化类型:
     * @return 格式为yyyy-MM-dd HH:mm:ss的时间字符串.
     */
    public static String stampToTime(long time, @PatternType String patternType) {
        Date date = new Date(time);
        mSimpleDateFormat.applyPattern(patternType);
        String res = mSimpleDateFormat.format(date);
        return res;
    }

    /**
     * 将时间字符串转换为时间戳.
     *
     * @param time        时间字符串
     * @param patternType 格式化类型:
     * @return 时间戳
     */
    public static long timeToStamp(String time, @PatternType String patternType) {
        mSimpleDateFormat.applyPattern(patternType);
        Date date = null;
        try {
            date = mSimpleDateFormat.parse(time);
        } catch (Exception e) {
            e.printStackTrace();
            return 0l;
        }
        return date.getTime();
    }

    /**
     * 获取两个日期相差的天数.
     *
     * @param oldDate 最早日期.
     * @param newDate 最晚日期.
     * @return 两个日期相差的天数
     */
    public static int getSeparatedDays(Date oldDate, Date newDate) {
        Calendar oldCalendar = Calendar.getInstance();
        oldCalendar.setTime(oldDate);

        Calendar newCalendar = Calendar.getInstance();
        newCalendar.setTime(newDate);

        int oldDay = oldCalendar.get(Calendar.DAY_OF_YEAR);
        int newDay = newCalendar.get(Calendar.DAY_OF_YEAR);

        int oldYear = oldCalendar.get(Calendar.YEAR);
        int newYear = newCalendar.get(Calendar.YEAR);
        if (oldYear != newYear) {//同一年
            int timeDistance = 0;
            for (int i = oldYear; i < newYear; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {    //闰年
                    timeDistance += 366;
                } else {  //不是闰年
                    timeDistance += 365;
                }
            }
            return timeDistance + (newDay - oldDay);
        } else { //不同年
            System.out.println("判断day2 - oldDay : " + (newDay - oldDay));
            return newDay - oldDay;
        }
    }

    /**
     * 比较两个时间戳相差的天数.
     *
     * @param oldStamp 毫秒时间戳之前的
     * @param newStamp 毫秒时间戳之后的
     * @return 相差的天数
     */
    public static int getSeparatedDays(long oldStamp, long newStamp) {
        return getSeparatedDays(new Date(oldStamp), new Date(newStamp));
    }

    public static String showTime(long elapsed) {
        String time = "1分钟前";
        if (elapsed > TIME_UNIT_DAY) {
            return String.format(Locale.CHINA, "%d天前", (int) (elapsed / TIME_UNIT_DAY));
        }

        if (elapsed > TIME_UNIT_HOUR) {
            return String.format(Locale.CHINA, "%d小时前", (int) (elapsed / TIME_UNIT_HOUR));
        }

        if (elapsed > TIME_UNIT_MINUTIUE) {
            return String.format(Locale.CHINA, "%d分钟前", (int) (elapsed / TIME_UNIT_MINUTIUE));
        }

        return time;
    }

    public static String showGameTime(long elapsed) {
        String time = "1分钟前";
        if (elapsed > TIME_UNIT_DAY) {
            return String.format(Locale.CHINA, "%d天", (int) (elapsed / TIME_UNIT_DAY));
        }

        if (elapsed > TIME_UNIT_HOUR) {
            return String.format(Locale.CHINA, "%d小时", (int) (elapsed / TIME_UNIT_HOUR));
        }

        if (elapsed > TIME_UNIT_MINUTIUE) {
            return String.format(Locale.CHINA, "%d分钟", (int) (elapsed / TIME_UNIT_MINUTIUE));
        }

        return time;
    }

    @Deprecated
    public static String getDateToString(long time) {
        time = time / 1000;
        if (time < 60) {
            return Math.max(0, time) + "秒";
        } else if (time > 60 && time < 3600) {
            int m = (int) (time / 60);
            int s = (int) (time % 60);
            return m + "分钟" + s + "秒";
        } else if (time >= 3600 && time < 86400) {
            int h = (int) (time / 3600);
            int m = (int) (time % 3600 / 60);
            int s = (int) (time % 3600 % 60 % 60);
            return h + "小时" + m + "分钟" + s + "秒";
        } else {
            int d = (int) (time / 86400);
            int h = (int) (time % 86400 / 3600);
            int m = (int) (time % 86400 % 3600 / 60);
            int s = (int) (time % 86400 % 3600 % 60 % 60);
            return d + "天" + h + "小时" + m + "分钟" + s + "秒";
        }
    }

    //月份字符串转换成英文
    public static String month2en(String month) {
        String en = "";
        int monthI = Integer.valueOf(month);
        if (monthI > 12) {
            en = "";
        } else {
            if (monthI == 1) {
                en = "January";
            } else if (monthI == 2) {
                en = "February";
            } else if (monthI == 3) {
                en = "March";
            } else if (monthI == 4) {
                en = " April";
            } else if (monthI == 5) {
                en = "May";
            } else if (monthI == 6) {
                en = "June";
            } else if (monthI == 7) {
                en = "July";
            } else if (monthI == 8) {
                en = "August";
            } else if (monthI == 9) {
                en = " September";
            } else if (monthI == 10) {
                en = "October";
            } else if (monthI == 11) {
                en = "November";
            } else if (monthI == 12) {
                en = "December";
            }
        }
        en = en.substring(0, 3);
        return en;
    }

    /**
     * 倒计时：分：秒
     *
     * @param duration 时间戳
     * @return 倒计时
     */
    public static String timeParse(long duration) {
        String time = "";
        long minute = duration / 60;
        long seconds = duration % 60;
//        float second = (float)seconds/100.0f;
//        if( minute < 10 ){
//            time += "0" ;
//        }
        time += minute + ":";
        if (seconds < 10) {
            time += "0";
        }
//        if( second < 10 ){
//            time += "0" ;
//        }
        time += seconds;
        return time;
    }

    @Deprecated
    public static String stringForTime(long timeMs) {
        long totalSeconds = timeMs / 1000;

        long seconds = totalSeconds % 60;
        long minutes = (totalSeconds / 60) % 60;
        long hours = totalSeconds / 3600;
        StringBuilder mFormatBuilder = new StringBuilder();
        Formatter mFormatter = new Formatter(mFormatBuilder, Locale.getDefault());
        mFormatBuilder.setLength(0);
        if (hours > 0) {
            return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        } else {
            return mFormatter.format("%02d:%02d", minutes, seconds).toString();
        }
    }

}

//    public static String getTomorrow() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH) + 1;
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        return year + "-" + (month > 9 ? month : ("0" + month)) + "-" + day;
//    }
//
//    public static String getDayTomorrow(int Y, int M, int D) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Y, M, D);
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH) + 1;
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        return (month > 9 ? month : ("0" + month)) + "月" + (day > 9 ? day : ("0" + day));
//    }

//    /**
//     * 取月开始结束时间
//     *
//     * @param month 0为本月 -1为上月 1为下月
//     * @return
//     */
//    public static List<String> getMonthBeginAndEndTime(int month) {
//        Calendar calendar = new GregorianCalendar();
//        if (month != 0) {
//            calendar.add(Calendar.MONTH, month);
//        }
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
//        Date date1 = calendar.getTime();
//        String beginDate = formatDate(date1.getTime(), ymd);
//
//        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
//        Date date2 = calendar.getTime();
//        String endDate = formatDate(date2.getTime(), ymd);
//
//        List<String> list = new ArrayList<>();
//        list.add(beginDate);
//        list.add(endDate);
//        return list;
//    }

//    /**
//     * 上周开始结束时间 上周周一到上周周日
//     *
//     * @return
//     */
//    public static List<String> getLastWeekBeginAndEndTime() {
//        Calendar cal = Calendar.getInstance();
//
//        String endTime = "";
//        String beginTime = "";
//        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
//            cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//            cal.set(Calendar.DAY_OF_WEEK, 1);
//            cal.add(Calendar.WEEK_OF_MONTH, -1);
//            endTime = formatDate(cal.getTime().getTime(), ymd);
//
//            cal.add(Calendar.WEEK_OF_MONTH, -1);
//            cal.set(Calendar.DAY_OF_WEEK, 2);
//            beginTime = formatDate(cal.getTime().getTime(), ymd);
//
//        } else {
//            cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
//            cal.set(Calendar.DAY_OF_WEEK, 1);
//            endTime = formatDate(cal.getTime().getTime(), ymd);
//
//            cal.add(Calendar.WEEK_OF_MONTH, -1);
//            cal.set(Calendar.DAY_OF_WEEK, 2);
//            beginTime = formatDate(cal.getTime().getTime(), ymd);
//        }
//
//        List<String> list = new ArrayList<>();
//        list.add(beginTime);
//        list.add(endTime);
//
//        return list;
//    }

//    /**
//     * 本周开始结束时间 周一到周日
//     *
//     * @return
//     */
//    public static List<String> getWeekBeginAndEndTime() {
//        Calendar cal = Calendar.getInstance();
//        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
//            cal.add(Calendar.DATE, -1);//如果当前时间是星期日,减去一天再获取周一,否则获取的是下周一日期
//        }
//        cal.set(Calendar.DAY_OF_WEEK, 2);
//        String beginTime = formatDate(cal.getTime().getTime(), ymd);
//        String endDate = "";
//        cal = Calendar.getInstance();
//        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
//            endDate = formatDate(cal.getTime().getTime(), ymd);//如果当前时间是星期日则结束时间为当前时间
//        } else {
//            cal.set(Calendar.DAY_OF_WEEK, 7);
//            cal.add(Calendar.DATE, 1);
//            endDate = formatDate(cal.getTime().getTime(), ymd);
//        }
//        List<String> list = new ArrayList<>();
//        list.add(beginTime);
//        list.add(endDate);
//        return list;
//    }

//    public static String getToday() {
//        Calendar calendar = Calendar.getInstance();
//        int year = calendar.get(Calendar.YEAR);
//        int month = calendar.get(Calendar.MONTH) + 1;
//        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        return year + "-" + (month > 9 ? month : ("0" + month)) + "-" + (day > 9 ? day : ("0" + day));
//    }
//
//    public static List<Integer> getDateForString(String date) {
//        String[] dates = date.split("-");
//        List<Integer> list = new ArrayList<>();
//        list.add(Integer.parseInt(dates[0]));
//        list.add(Integer.parseInt(dates[1]));
//        list.add(Integer.parseInt(dates[2]));
//        return list;
//    }
//
//    public static Calendar getCalendar(Date date) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        return calendar;
//    }


//    public static String formatDate(String date, String format) {
//        String resultD = date;
//        SimpleDateFormat sdf = new SimpleDateFormat(format);
//        try {
//            Date d = sdf.parse(date);
//            resultD = sdf.format(d);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return resultD;
//    }
//
//    public static String formatDate(long milliseconds, String format) {
//        String resultD = "";
//        SimpleDateFormat sdf = new SimpleDateFormat(format);
//        try {
//            Date d = new Date(milliseconds);
//            resultD = sdf.format(d);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return resultD;
//    }

//    public static int[] getWeekDay(int Y, int M, int D) throws ParseException {
//
//        int[] is = new int[6];
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //设置时间格式
//        Calendar cal = Calendar.getInstance();
//        String s = Y + "-" + M + "-" + D;
//        Date time = sdf.parse(s + " 14:22:47");
//        cal.setTime(time);
//        System.out.println("要计算日期为:" + sdf.format(cal.getTime())); //输出要计算日期
//
//
//        //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
//        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
//        if (1 == dayWeek) {
//            cal.add(Calendar.DAY_OF_MONTH, -1);
//        }
//
//        cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
//
//        int day = cal.get(Calendar.DAY_OF_WEEK);//获得当前日期是一个星期的第几天
//        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);//根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
//        System.out.println("所在周星期一的日期：" + sdf.format(cal.getTime()));
//        is[0] = Integer.parseInt(sdf.format(cal.getTime()).split("-")[0]);
//        is[1] = Integer.parseInt(sdf.format(cal.getTime()).split("-")[1]);
//        is[2] = Integer.parseInt(sdf.format(cal.getTime()).split("-")[2]);
//
//
//        System.out.println(cal.getFirstDayOfWeek() + "-" + day + "+6=" + (cal.getFirstDayOfWeek() - day + 6));
//
//        cal.add(Calendar.DATE, 6);
//        is[3] = Integer.parseInt(sdf.format(cal.getTime()).split("-")[0]);
//        is[4] = Integer.parseInt(sdf.format(cal.getTime()).split("-")[1]);
//        is[5] = Integer.parseInt(sdf.format(cal.getTime()).split("-")[2]);
//        System.out.println("所在周星期日的日期：" + sdf.format(cal.getTime()));
//        return is;
//    }

//    public static String getDayWeek(String date) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(formatDateStr(date, ymd));
//        switch (calendar.get(Calendar.DAY_OF_WEEK)) {
//            case 1:
//                return "周日";
//
//            case 2:
//                return "周一";
//
//            case 3:
//                return "周二";
//
//            case 4:
//                return "周三";
//
//            case 5:
//                return "周四";
//
//            case 6:
//                return "周五";
//
//            case 7:
//                return "周六";
//
//            default:
//                return "";
//        }
//    }