package com.ztime.lib;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

/**
 * 时间工具类
 * Created by zxn on 2019/02/19.
 */
public class ZTimeUtils {

    /**
     *  类型{@link #yMdHmS}:为24小时制日期格式:yyyy-MM-dd HH:mm:ss.
     */
    public static final int FORMAT_TYPE_yMdHmS = 0;

    @IntDef({FORMAT_TYPE_yMdHmS})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FormatType {
    }

    /**
     * 将时间戳转换为日期字符串.
     *
     * @param time  时间戳
     * @param formatType    格式化类型See {@link #FORMAT_TYPE_yMdHmS}
     *
     * @return  格式为yyyy-MM-dd HH:mm:ss的时间字符串.
     */
    public static String stampToDate(long time, @FormatType int formatType) {
        String res;
        Date date = new Date(time);
        res = yMdHmS.format(date);
        return res;
    }

    private static final int TIME_UNIT_SECOND = 1;
    private static final int TIME_UNIT_MINUTIUE = TIME_UNIT_SECOND * 60;//分钟
    private static final int TIME_UNIT_HOUR = TIME_UNIT_MINUTIUE * 60;//小时
    private static final int TIME_UNIT_DAY = TIME_UNIT_HOUR * 24;//天
    private static final int TIME_UNIT_YEAR = TIME_UNIT_DAY * 365;//年

    /**
     * 年月日时分秒,格式为24小时制日期格式:yyyy-MM-dd HH:mm:ss
     */
    private static SimpleDateFormat yMdHmS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //年月日时分
    private static SimpleDateFormat yMdHm = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    //年月日
    private static SimpleDateFormat yMd = new SimpleDateFormat("yyyy-MM-dd");

    //24小时制月日时分
    private static SimpleDateFormat MdHm = new SimpleDateFormat("MM-dd HH:mm");
    //24小时制时分
    private static SimpleDateFormat hourMinuteFormat = new SimpleDateFormat("HH:mm");

    //12小时制时分
    private static SimpleDateFormat hourminuteFormat = new SimpleDateFormat("hh:mm");

    //月日
    private static SimpleDateFormat Md = new SimpleDateFormat("MM-dd");

    //24小时制时分秒
    private static SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");

    //分秒
    private static SimpleDateFormat ms = new SimpleDateFormat("mm:ss");

    //秒
    private static SimpleDateFormat s = new SimpleDateFormat("s");


    /**
     * 获取当前年月日格式的时间,例如:yyyy-MM-dd
     *
     * @return 日期时间
     */
    public static String getCurrentYearMonthDayTime() {
        Date curDate = new Date(System.currentTimeMillis());
        return yMd.format(curDate);
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
     * 获取当前时分格式的时间,例如:11:25
     *
     * @return 日期时间
     */
    public static String getHourMinTime() {
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = hourMinuteFormat.format(curDate);
        return str;
    }

    @Deprecated
    public static String getHourMinutesTime() {
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = hourMinuteFormat.format(curDate);
        return str;
    }

    /**
     * 判断是否为同一天
     *
     * @param time1 时间戳
     * @param time2 时间戳
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
     * 得到现在分钟
     *
     * @return 时间
     */

    public static String getMinTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        String min = dateString.substring(14, 16);
        return min;
    }

    /**
     * 得到现在小时
     *
     * @return 时间字符串.
     */
    public static String getHourTime() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        String hour = dateString.substring(11, 13);
        return hour;
    }


    /**
     * 获取当前日期中的天数.例如今天是2019.02.19,返回19
     *
     * @return 前日期中的天
     */
    public static String getDayTime() {
        long currentTime = System.currentTimeMillis();
        String currentFormat = Md.format(currentTime);
        return currentFormat.substring(3);
    }

    /**
     * 获取当前日期中的天数.例如今天是2019.02.19,返回19
     *
     * @return 前日期中的天
     */
    public static String getDay() {
        long currentTime = System.currentTimeMillis();
        String currentFormat = Md.format(currentTime);
        return currentFormat.substring(3);
    }

    /**
     * 获取当前月份
     *
     * @return 时间字符串
     */
    public static String getMonthTime() {
        long currentTime = System.currentTimeMillis();
        String currentFormat = Md.format(currentTime);
        return currentFormat.substring(0, 2);
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


    /**
     * 年月日时分
     *
     * @param l 时间戳
     * @return 时间字符串
     */
    public static String formatTIme(long l) {
        return yMdHm.format(l);
    }

    /**
     * 年月日时分秒:yyyy-MM-dd HH:mm:ss
     *
     * @param l 时间戳
     * @return 时间字符串
     */
    public static String formatTime(long l) {
        return yMdHmS.format(l);
    }

    public static String getMinuteTime(long time) {
        if (time <= 0)
            return "00:00";

        return ms.format(time);
    }

    public static String getMinuteTime1(long time) {
        if (time <= 0)
            return "0";

        return s.format(time);
    }

    public static String getTimeForTask(long time) {
        try {
            return hms.format(time);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 红包里用到的时间
     *
     * @param stamp 时间戳
     * @return 日期时间
     */
    public static String showFormatTime(long stamp) {
        String time = "";
        //当前时间
        long currentTime = System.currentTimeMillis();
        //应该分别转换格式对比年月日时分秒
        String currentFormat = yMdHm.format(currentTime);
        String stampFormat = yMdHm.format(stamp);
        //非当年，显示为年月日
        if (!currentFormat.substring(0, 4).equals(stampFormat.substring(0, 4))) {
            time = yMd.format(stamp);
        } else {
            //当年的先判断是否一个月的
            if ((stampFormat.substring(5, 7).equals((currentFormat.substring(5, 7))))) {
                //是一个月的，判断是不是当天的
                if ((stampFormat.substring(8, 10).equals((currentFormat.substring(8, 10))))) {
                    //是当天的，显示时分
                    time = hourMinuteFormat.format(stamp);
                } else {
                    //是昨天的，显示为昨天
//                    if (Integer.parseInt(stampFormat.substring(8, 10)) + 1 == Integer.parseInt(currentFormat.substring(8, 10))) {
//                        time = "昨天";
//                    } else {
                    //不是昨天的,显示月日
                    time = Md.format(stamp);
//                    }
                }
            } else {
                //不是一个月，显示月日
                time = Md.format(stamp);
            }
        }

        return time;
    }


    //将当前的月份和日期转换成英文+数字的形式
    public static String date2en() {
        long currentTime = System.currentTimeMillis();
        String currentFormat = Md.format(currentTime);
        String month = month2en(currentFormat.substring(0, 2));
        return month + " " + currentFormat.substring(3);
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
     * 消息详情页面转换时间的方法
     * 强制使用12小时制的形式
     *
     * @param stamp 多少秒之前接受到的消息
     * @return 时间
     */

    public static String changeTimeFormat(long stamp) {
        String time = "";
        //当前时间
        long currentTime = System.currentTimeMillis();
        //应该分别转换格式对比年月日时分秒
        String currentFormat = yMdHm.format(currentTime);
        String stampFormat = yMdHm.format(stamp);
        //是12小时制
        //非当年，显示为年月日时分
        if (!currentFormat.substring(0, 4).equals(stampFormat.substring(0, 4))) {
            time = currentFormat;
        } else {
            //当年的先判断是否一个月的
            if ((stampFormat.substring(5, 7).equals((currentFormat.substring(5, 7))))) {
                //是一个月的，判断是不是当天的
                if ((stampFormat.substring(8, 10).equals((currentFormat.substring(8, 10))))) {
                    //是当天的，显示凌晨上午下午晚上+时分
                    if (Integer.parseInt(stampFormat.substring(11, 13)) <= 6) {
                        time = "凌晨 " + hourMinuteFormat.format(stamp);
                    } else if (Integer.parseInt(stampFormat.substring(11, 13)) <= 11) {
                        time = "上午" + hourminuteFormat.format(stamp);
                    } else if (Integer.parseInt(stampFormat.substring(11, 13)) <= 17) {
                        time = "下午" + hourminuteFormat.format(stamp);
                    } else if (Integer.parseInt(stampFormat.substring(11, 13)) <= 24) {
                        time = "晚上" + hourminuteFormat.format(stamp);
                    }
                } else {
                    //是昨天的，显示为昨天时分
                    if (Integer.parseInt(stampFormat.substring(8, 10)) + 1 == Integer.parseInt(currentFormat.substring(8, 10))) {
                        time = "昨天" + hourMinuteFormat.format(stamp);
                    } else {
                        //不是昨天的,显示月日时分
                        time = MdHm.format(stamp);
                    }
                }
            } else {
                //不是一个月，显示月日时分
                time = MdHm.format(stamp);
            }
        }

        return time;
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

    /**
     * 将时间戳转换为时间
     *
     * @param time 时间戳
     * @return 时间
     */
    public static String stampToDate(long time) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        res = simpleDateFormat.format(date);
        return res;
    }
}