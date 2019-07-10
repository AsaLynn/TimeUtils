package com.ztime.lib;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期操作工具类.
 * Created by zxn on 2019/6/29.
 */
public class DateUtils {

    //    @SuppressLint("SimpleDateFormat")
    private static final SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat();

    public static final String FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String formatNoSS = "yyyy-MM-dd HH:mm";
    public static final String formatNossSSSS = "yyyyMMddHHmmssSSS";

    public static final String formatNoTime = "yyyy-MM-dd";
    public static final String formatNoTime1 = "yyyyMMdd";

    public static final String formatAll = "yyyy-MM-dd HH:mm:ss";
    public static final String formatAll1 = "yyyyMMddHHmmss";

    public static SimpleDateFormat m = new SimpleDateFormat(formatAll1, Locale.getDefault());
    public static SimpleDateFormat m1 = new SimpleDateFormat(formatAll, Locale.getDefault());

    public static SimpleDateFormat t = new SimpleDateFormat("HHmmss", Locale.getDefault());
    public static SimpleDateFormat t1 = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());

    public static SimpleDateFormat n = new SimpleDateFormat(formatNoTime1, Locale.getDefault());
    public static SimpleDateFormat n1 = new SimpleDateFormat(formatNoTime, Locale.getDefault());

    public static SimpleDateFormat q = new SimpleDateFormat(FORMAT, Locale.getDefault());
    public static SimpleDateFormat q1 = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault());

    public static SimpleDateFormat q2 = new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault());


    /**
     * yyyy-MM-dd HH:mm:ss转yyyy年MM月dd日
     *
     * @param payTime
     * @return
     * @throws ParseException
     */
    public static String formatTimeQ2(String payTime) throws ParseException {
        return q2.format(q.parse(payTime));
    }

    /**
     * yyyy-MM-dd HH:mm:ss转yyyy.MM.dd
     *
     * @param payTime
     * @return
     * @throws ParseException
     */
    public static String formatTimeQ1(String payTime) throws ParseException {
        return q1.format(q.parse(payTime));
    }


    /**
     * yyyyMMddHHmmss转yyyy-MM-dd HH:mm:ss格式
     *
     * @param payTime
     * @return
     * @throws ParseException
     */
    public static String formatTime(String payTime) throws ParseException {
        return m1.format(m.parse(payTime));
    }

    /**
     * yyyyMMddHHmmss转yyyy-MM-dd HH:mm:ss格式
     *
     * @param payTime
     * @return
     * @throws ParseException
     */
    public static String formatTime_revert(String payTime) throws ParseException {
        return m.format(m1.parse(payTime));
    }

    /**
     * yyyy-MM-dd转yyyyMMdd格式
     *
     * @param payTime
     * @return
     * @throws ParseException
     */
    public static String formatTime1(String payTime) throws ParseException {
        return n.format(n1.parse(payTime));
    }

    /**
     * HHmmss转HH:mm:ss格式
     *
     * @param payTime
     * @return
     * @throws ParseException
     */
    public static String formatTimeTo(String payTime) throws ParseException {
        return t.format(t1.parse(payTime));
    }

    public static Date str2Date(String str, String format) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = FORMAT;
        }
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
            date = sdf.parse(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;

    }

    public static Calendar str2Calendar(String str) {
        return str2Calendar(str, null);

    }

    public static Calendar str2Calendar(String str, String format) {

        Date date = str2Date(str, format);
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c;

    }

    public static long str2Long(String str, String format) {

        Date date = str2Date(str, format);
        if (date == null) {
            return 0;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        return c.getTimeInMillis();

    }

    public static String date2Str(Calendar c, String format) {
        if (c == null) {
            return null;
        }
        return date2Str(c.getTime(), format);
    }


    public static String date2Str(Date d, String format) {// yyyy-MM-dd HH:mm:ss
        if (d == null) {
            return null;
        }
        if (format == null || format.length() == 0) {
            format = FORMAT;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        String s = sdf.format(d);
        return s;
    }

    public static String getCurDateStr() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        return c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH) + "-" + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":"
                + c.get(Calendar.SECOND);
    }

    /**
     * 获得当前日期的字符串格式
     *
     * @param format
     * @return
     */
    public static String getCurDateStr(String format) {
        Calendar c = Calendar.getInstance();
        return date2Str(c, format);
    }

    // 格式到秒
    public static String getMillon(long time) {
        return transferLongToDate("yyyy-MM-dd HH:mm:ss", time);
    }

    // 格式到天
    public static String getDay(long time) {

        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(time);
    }

    // 格式到天
    public static String getDay() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(System.currentTimeMillis());
    }

//    // 格式到毫秒
//    public static String getSMillon(long time) {
//        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS", Locale.getDefault()).format(time);
//    }

    // 格式时分
    public static String getTime(long time) {
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(time);
    }

    public static String transferLongToDate(String dateFormat, Long millSec) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.getDefault());
        Date date = new Date(millSec);
        return sdf.format(date);
    }

    /**
     * 判断两个日期是否是同一天
     *
     * @param date1 date1
     * @param date2 date2
     * @return
     */
    public static boolean isSameDate(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        boolean isSameMonth = isSameYear && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);

        return isSameDate;
    }

    /**
     * 判断给定日期是否和今天是同一天.
     *
     * @param dateText dateText 给定日期字符串.
     * @param pattern  时间格式.
     * @return true:为同一天.
     */
    public static boolean isToday(String dateText, @PatternType String pattern) {
        mSimpleDateFormat.applyPattern(pattern);
        Calendar dateCalendar = Calendar.getInstance();
        try {
            dateCalendar.setTime(mSimpleDateFormat.parse(dateText));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        int dateYear = dateCalendar.get(Calendar.YEAR);
        int dateMonth = dateCalendar.get(Calendar.MONTH);
        int dateDay = dateCalendar.get(Calendar.DAY_OF_MONTH);
        Calendar calendar = Calendar.getInstance();
        int todayYear = calendar.get(Calendar.YEAR);
        int todayMonth = calendar.get(Calendar.MONTH);
        int todayDay = calendar.get(Calendar.DAY_OF_MONTH);
        return dateYear == todayYear && dateMonth == todayMonth && dateDay == todayDay;
    }

    /**
     * 根据当前日期往前推算yearCount年前或者yearCount年后的日期.
     *
     * @param yearCount 年数,正数往后推算,负数往前推算.
     * @param pattern   时间格式.
     * @return 返回yearCount年之前的日期.
     */
    public static String calculateDateByYear(int yearCount, @PatternType String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + yearCount);
        mSimpleDateFormat.applyPattern(pattern);
        return mSimpleDateFormat.format(calendar.getTime());
    }

    /***
     * 根据当前时间推算dayCount天前或dayCount天后的时间.
     * @param dayCount  相差的天数.
     * @return 推算dayCount天前或dayCount天后的时间.
     * @param pattern 格式
     */
    public static String calculateDateByDay(int dayCount, @PatternType String pattern) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + dayCount);
        mSimpleDateFormat.applyPattern(pattern);
        return mSimpleDateFormat.format(calendar.getTime());
    }

    /**
     * 判断给定日期是否和今天的月份相同
     *
     * @param dateText dateText 给定日期字符串.
     * @param pattern  时间格式.
     * @return true:日期中的月份相同.
     */
    public static boolean isSameMonth(String dateText, @PatternType String pattern) {
        mSimpleDateFormat.applyPattern(pattern);
        Calendar dateCalendar = Calendar.getInstance();
        try {
            dateCalendar.setTime(mSimpleDateFormat.parse(dateText));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        int dateMonth = dateCalendar.get(Calendar.MONTH);

        Calendar calendar = Calendar.getInstance();
        int todayMonth = calendar.get(Calendar.MONTH);

        return dateMonth == todayMonth;
    }


    /**
     * 判断给定日期是否和今天的日子相同(即日子相同但是月份和年份未必相同).
     *
     * @param dateText dateText 给定日期字符串.
     * @param pattern  时间格式.
     * @return true:日期中的天相同.
     */
    public static boolean isSameDay(String dateText, @PatternType String pattern) {
        mSimpleDateFormat.applyPattern(pattern);
        Calendar dateCalendar = Calendar.getInstance();
        try {
            dateCalendar.setTime(mSimpleDateFormat.parse(dateText));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        int dateDay = dateCalendar.get(Calendar.DAY_OF_MONTH);
        Calendar calendar = Calendar.getInstance();

        int todayDay = calendar.get(Calendar.DAY_OF_MONTH);
        return dateDay == todayDay;
    }

    /**
     * 判断给定日期是否和今天的月份和天分别相同,可以用作是否是生日判断.
     *
     * @param dateText dateText 给定日期字符串.
     * @param pattern  时间格式.
     * @return true:日期中的月份和天相同.
     */
    public static boolean isSameMonthDay(String dateText, @PatternType String pattern) {
        return isSameDay(dateText, pattern) && isSameMonth(dateText, pattern);
    }



}
