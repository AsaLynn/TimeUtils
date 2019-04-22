package com.ztime.lib;

import android.annotation.SuppressLint;
import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

/**
 * 时间工具类--SDFPattern
 * Created by zxn on 2019/02/19.
 */
public class ZTimeUtils {

    @SuppressLint("SimpleDateFormat")
    private static final SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat();

    @StringDef({SDFPattern.yMdHm_SDF_POIONT,
            SDFPattern.yMdHmS_SDF,
            SDFPattern.yMdHm_SDF,
            SDFPattern.Hm_SDF,
            SDFPattern.yMdH_SDF,
            SDFPattern.yMd_SDF,
            SDFPattern.yM_SDF,
            SDFPattern.HmS_SDF,
            SDFPattern.Md_SDF,
            SDFPattern.yMdHmS_SDF_NYR,
//            SDFPattern.Md_SDF_YR,
            SDFPattern.MdHmS_SDF_YR,
            SDFPattern.yMd_SDF_NYR,
            SDFPattern.yMd1_SDF_NYR,
            SDFPattern.yMd1HmS_SDF_NYR,
            SDFPattern.yM1d1HmS_SDF_NYR,
            SDFPattern.yM1d1_SDF_NYR,
            SDFPattern.M1d1HmS_SDF_YR,
            SDFPattern.M1d1_SDF_YR,
            SDFPattern.yM1d1HHmm_SDF_NYR,
            SDFPattern.M1d1HHmm_SDF_YR,
            SDFPattern.yyyyMMddHHmmSS_SDF_RRCC,
            SDFPattern.yyyyMMddHHmm_SDF_RRC,
            SDFPattern.yyyyMMddHH_SDF_RR,
            SDFPattern.yyyyMMdd_SDF_RR,
            SDFPattern.yyyyMM_SDF_R,
            SDFPattern.MMdd_SDF_R,
            SDFPattern.HHmmSS_SDF_CC,
            SDFPattern.yyyyMMddHHmm_SDF_PPC,
            SDFPattern.HHmm_SDF_C,
            SDFPattern.yyyyMMddHHmmSS_SDF_YMDCC,
            SDFPattern.yyyyMdHHmmSS_SDF_YMDCC,
            SDFPattern.yyyyMdHHmm_SDF_YMDC,
            SDFPattern.yyyyMMdd_SDF_YMD,
            SDFPattern.yyyyMd_SDF_YMD,
            SDFPattern.MMdd_SDF_MD,
            SDFPattern.Md_SDF_MD,
            SDFPattern.MMddHHmmSS_SDF_MDCC,
            SDFPattern.MdHHmmSS_SDF_MDCC,
            SDFPattern.MdHHmm_SDF_MDC,
            SDFPattern.yyyyMMddHHmmss_SDF,
            SDFPattern.MMRdd_SDF,
            SDFPattern.yyyySPMMSPdd_SDF,

            //SDFPattern.M1d1_SDF_YR,
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface PatternType {
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

    /**
     * 将时间戳转换为日期字符串,方法有待完善.
     *
     * @param time        时间戳
     * @param patternType 格式化类型: One of {@link SDFPattern#yMdHm_SDF_POIONT },
     *                    {@link SDFPattern#yMdHmS_SDF },{@link SDFPattern#yMdHm_SDF }, or {@link SDFPattern#Hm_SDF }.
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
     * @param patternType 格式化类型: One of {@link SDFPattern#yMdHm_SDF_POIONT },@link SDFPattern#yMdHmS_SDF },{@link SDFPattern#yMdHm_SDF }, or {@link SDFPattern#Hm_SDF }.
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
     * 将时间字符串转换为时间戳.
     *
     * @param time 时间字符串:2019-02-28.
     * @return 时间戳
     */
    @Deprecated
    public static long timeToStamp(String time) {
        mSimpleDateFormat.applyPattern(SDFPattern.yMdHmS_SDF);
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

    /**
     * 年月日时分秒,格式为24小时制日期格式:yyyy-MM-dd HH:mm:ss
     */
    @Deprecated
    private static SimpleDateFormat yMdHmS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 年月日时分,格式为24小时制日期格式:yyyy-MM-dd HH:mm
     */
    @Deprecated
    private static SimpleDateFormat yMdHm = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    /**
     * 24小时制时分,格式为24小时制日期格式:HH:mm
     */
    @Deprecated
    private static SimpleDateFormat Hm = new SimpleDateFormat("HH:mm");


    //年月日
    @Deprecated
    private static SimpleDateFormat yMd = new SimpleDateFormat("yyyy-MM-dd");

    //24小时制月日时分
    @Deprecated
    private static SimpleDateFormat MdHm = new SimpleDateFormat("MM-dd HH:mm");


    //12小时制时分
    @Deprecated
    private static SimpleDateFormat hourminuteFormat = new SimpleDateFormat("hh:mm");

    //月日
    @Deprecated
    private static SimpleDateFormat Md = new SimpleDateFormat("MM-dd");

    //24小时制时分秒
    @Deprecated
    private static SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");

    //分秒
    @Deprecated
    private static SimpleDateFormat ms = new SimpleDateFormat("mm:ss");

    //秒
    @Deprecated
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
        String str = Hm.format(curDate);
        return str;
    }

    @Deprecated
    public static String getHourMinutesTime() {
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str = Hm.format(curDate);
        return str;
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

    @Deprecated
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
                    time = Hm.format(stamp);
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
                        time = "凌晨 " + Hm.format(stamp);
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
                        time = "昨天" + Hm.format(stamp);
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

    private static final int TIME_UNIT_SECOND = 1;
    private static final int TIME_UNIT_MINUTIUE = TIME_UNIT_SECOND * 60;//分钟
    private static final int TIME_UNIT_HOUR = TIME_UNIT_MINUTIUE * 60;//小时
    private static final int TIME_UNIT_DAY = TIME_UNIT_HOUR * 24;//天
    private static final int TIME_UNIT_YEAR = TIME_UNIT_DAY * 365;//年

//------------------------------------------------------以下为过时的方法和常量,待抛弃--------------------------------------------------------------------//

    /**
     * 年月日时分
     *
     * @param l 时间戳
     * @return 时间字符串
     */
    @Deprecated
    public static String formatTIme(long l) {
        return yMdHm.format(l);
    }


    /**
     * 将时间戳转换为时间
     *
     * @param time 时间戳
     * @return 时间
     */
    @Deprecated
    public static String stampToDate(long time) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        res = simpleDateFormat.format(date);
        return res;
    }


    /**
     * 类型{@link #yMdHmS}:为24小时制日期格式:yyyy-MM-dd HH:mm:ss.
     */
    @Deprecated
    public static final int FORMAT_TYPE_yMdHmS = 10;

    /**
     * 类型{@link #yMdHm}:为24小时制日期格式:yyyy-MM-dd HH:mm.
     */
    @Deprecated
    public static final int FORMAT_TYPE_yMdHm = 20;

    /**
     * 类型{@link #yMdHm}:为24小时制日期格式:yyyy.MM.dd HH:mm.
     */
    @Deprecated
    public static final int FORMAT_TYPE_yMdHm_Point = 21;

    /**
     * 类型{@link #Hm}:为24小时制日期格式:HH:mm.
     */
    @Deprecated
    public static final int FORMAT_TYPE_Hm = 2;


    @Deprecated
    @IntDef({FORMAT_TYPE_yMdHmS, FORMAT_TYPE_yMdHm, FORMAT_TYPE_Hm, FORMAT_TYPE_yMdHm_Point})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FormatType {
    }

    /**
     * 将时间戳转换为日期字符串.
     *
     * @param time       时间戳
     * @param formatType 格式化类型: One of {@link #FORMAT_TYPE_yMdHmS}, {@link #FORMAT_TYPE_yMdHm}, or {@link #FORMAT_TYPE_yMdHm}.
     * @return 格式为yyyy-MM-dd HH:mm:ss的时间字符串.
     */
    @Deprecated
    public static String stampToDate(long time, @FormatType int formatType) {
        String res;
        Date date = new Date(time);
        if (formatType == FORMAT_TYPE_yMdHmS) {
            mSimpleDateFormat.applyPattern(SDFPattern.yMdHmS_SDF);
        } else if (formatType == FORMAT_TYPE_yMdHm) {
            mSimpleDateFormat.applyPattern(SDFPattern.yMdHm_SDF);
        } else if (formatType == FORMAT_TYPE_Hm) {
            mSimpleDateFormat.applyPattern(SDFPattern.Hm_SDF);
        } else if (formatType == FORMAT_TYPE_yMdHm_Point) {
            mSimpleDateFormat.applyPattern(SDFPattern.yMdHm_SDF_POIONT);
        } else {
            mSimpleDateFormat.applyPattern(SDFPattern.yMdHmS_SDF);
        }
        res = mSimpleDateFormat.format(date);
        return res;
    }

    /**
     * 年月日时分秒:yyyy-MM-dd HH:mm:ss
     *
     * @param l 时间戳
     * @return 时间字符串
     */
    @Deprecated
    public static String formatTime(long l) {
        return yMdHmS.format(l);
    }

}
