package com.ztime.lib;


public class StampUtils {


    /**
     * 比较两个时间相差的秒数.
     *
     * @param startStamp
     * @param endStamp
     * @return
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

}
