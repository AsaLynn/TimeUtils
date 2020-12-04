package com.zxn.time

import java.text.DecimalFormat
import java.util.*
import kotlin.math.abs

object StampUtils {

    /**
     * 判断给定的时间戳距离现在相差多久
     * stamp:给定的时间戳
     * unitType:单位类型
     * 返回结果保留指定位数的小数点
     */
    fun howLong(stamp: Long, @TimeUnitType unitType: Int, format: DecimalFormat? = null): String {

        when (unitType) {
            TimeUnitPattern.DAY -> {
                return if (format == null) {
                    (abs(System.currentTimeMillis() - stamp) / MillisPatternUnit.DAY_MILLIS).toString()
                } else {//5231687
                    format.format((abs(System.currentTimeMillis() - stamp) / MillisPatternUnit.DAY_MILLIS.toDouble()))
                }
            }
            else -> {
                return if (format == null) {
                    (abs(System.currentTimeMillis() - stamp)).toString()
                } else {
                    format.format((abs(System.currentTimeMillis() - stamp)).toDouble())
                }
            }
        }
    }

    /**
     * 判断是否为周末.
     *
     * @param stamp 日期时间戳
     * @return true为周末
     */
    fun isWeekend(stamp: Long): Boolean {
        val calendar = Calendar.getInstance()
        calendar.time = Date(stamp)
        return (calendar[Calendar.DAY_OF_WEEK] == Calendar.SATURDAY
                || calendar[Calendar.DAY_OF_WEEK] == Calendar.SUNDAY)
    }

    /**
     * 判断时间戳是否为0秒
     *
     * @param stamp 时间戳
     * @return 真
     */
    fun isZeroSecond(stamp: Long): Boolean {
        val date = Date(stamp)
        return date.seconds == 0
    }

    /**
     * 判断是否为同一天
     *
     * @param time1 时间戳1
     * @param time2 时间戳2
     * @return boolean
     */
    fun isSameDay(time1: Long, time2: Long): Boolean {
        val calendar = Calendar.getInstance()
        calendar.time = Date(time1)
        val day1 = calendar[Calendar.DAY_OF_YEAR]
        calendar.time = Date(time2)
        val day2 = calendar[Calendar.DAY_OF_YEAR]
        return day1 == day2
    }

    /**
     * 比较两个时间相差的秒数.
     *
     * @param startStamp    startStamp
     * @param endStamp  startStamp
     * @return  相差的秒数.
     */
    fun secondsDifference(startStamp: Long, endStamp: Long): Long {
        return (endStamp - startStamp) / MillisPatternUnit.SEC_MILLIS
    }

    /**
     * 比较给定时间和当前时间的差距s.
     *
     * @param stamp
     * @return
     */
    fun secondsDifference(stamp: Long): Long {
        return (System.currentTimeMillis() - stamp) / MillisPatternUnit.SEC_MILLIS
    }

    /**
     * 判断是否为同一月
     *
     * @param stamp1 时间戳1
     * @param stamp2 时间戳2
     * @return boolean
     */
    fun isSameMonth(stamp1: Long, stamp2: Long): Boolean {
        val calendar = Calendar.getInstance()
        calendar.time = Date(stamp1)
        val month1 = calendar[Calendar.MONTH]
        calendar.time = Date(stamp2)
        val month2 = calendar[Calendar.MONTH]
        return month1 == month2
    }

    /**
     * 判断是否为同一年
     *
     * @param stamp1 时间戳1
     * @param stamp2 时间戳2
     * @return boolean
     */
    fun isSameYear(stamp1: Long, stamp2: Long): Boolean {
        val calendar = Calendar.getInstance()
        calendar.time = Date(stamp1)
        val year1 = calendar[Calendar.YEAR]
        calendar.time = Date(stamp2)
        val year2 = calendar[Calendar.YEAR]
        return year1 == year2
    }
}