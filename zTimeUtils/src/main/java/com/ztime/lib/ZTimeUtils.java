package com.ztime.lib;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

/**
 * 时间工具类--SDFPattern
 * DateUtils...
 * Created by zxn on 2019/02/19.
 */
public class ZTimeUtils {

    @SuppressLint("SimpleDateFormat")
    private static final SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat();

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

    /***
     *
     * @param dayCount
     * @return
     */
    /**
     * 根据指定时间推算dayCount天前或dayCount天后的时间.
     * @param dayCount  相差的天数.
     * @param date  date
     * @param pattern   pattern
     * @return  推算dayCount天前或dayCount天后的时间.
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

    //12小时制时分
    @Deprecated
    private static SimpleDateFormat hourminuteFormat = new SimpleDateFormat("hh:mm");

//
//    /**
//     * 获取当前时间是上午还是下午:afternoon,midday,morning
//     *
//     * @return AM, PM
//     */
//    public static String getCurrentTimeType() {
//        long time = System.currentTimeMillis();
//        final Calendar mCalendar = Calendar.getInstance();
//        mCalendar.setTimeInMillis(time);
//        int apm = mCalendar.get(Calendar.AM_PM);
//        if (apm == 0) {
//            return "AM";
//        } else {
//            return "PM";
//        }
//    }

//    /**
//     * 获取当前时分格式的时间,例如:11:25
//     *
//     * @return 日期时间
//     */
//    public static String getHourMinTime() {
//        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
//        String str = Hm.format(curDate);
//        return str;
//    }

//    @Deprecated
//    public static String getHourMinutesTime() {
//        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
//        String str = Hm.format(curDate);
//        return str;
//    }


//    /**
//     * 得到现在分钟
//     *
//     * @return 时间
//     */
//
//    public static String getMinTime() {
//        Date currentTime = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateString = formatter.format(currentTime);
//        String min = dateString.substring(14, 16);
//        return min;
//    }

//    /**
//     * 得到现在小时
//     *
//     * @return 时间字符串.
//     */
//    public static String getHourTime() {
//        Date currentTime = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String dateString = formatter.format(currentTime);
//        String hour = dateString.substring(11, 13);
//        return hour;
//    }


//    /**
//     * 获取当前日期中的天数.例如今天是2019.02.19,返回19
//     *
//     * @return 前日期中的天
//     */
//    public static String getDayTime() {
//        long currentTime = System.currentTimeMillis();
//        String currentFormat = Md.format(currentTime);
//        return currentFormat.substring(3);
//    }

//    /**
//     * 获取当前日期中的天数.例如今天是2019.02.19,返回19
//     *
//     * @return 前日期中的天
//     */
//    public static String getDay() {
//        long currentTime = System.currentTimeMillis();
//        String currentFormat = Md.format(currentTime);
//        return currentFormat.substring(3);
//    }

//    /**
//     * 获取当前月份
//     *
//     * @return 时间字符串
//     */
//    public static String getMonthTime() {
//        long currentTime = System.currentTimeMillis();
//        String currentFormat = Md.format(currentTime);
//        return currentFormat.substring(0, 2);
//    }

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

    /* 时间戳转换成字符窜 */
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


    Long gg = 1000 * 60l, mmax = gg * 60, hmax = mmax * 24, dmax = hmax * 30;


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

    private static final int TIME_UNIT_SECOND = 1;
    private static final int TIME_UNIT_MINUTIUE = TIME_UNIT_SECOND * 60;//分钟
    private static final int TIME_UNIT_HOUR = TIME_UNIT_MINUTIUE * 60;//小时
    private static final int TIME_UNIT_DAY = TIME_UNIT_HOUR * 24;//天
    private static final int TIME_UNIT_YEAR = TIME_UNIT_DAY * 365;//年


}
