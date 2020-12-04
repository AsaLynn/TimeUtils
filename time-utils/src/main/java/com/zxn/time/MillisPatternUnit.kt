package com.zxn.time

/**
 * TimePatternUnit
 * Updated by zxn on 2020/4/28.
 */
interface MillisPatternUnit {
    companion object {
        /**
         * 一天的毫秒数
         */
        const val DAY_MILLIS = 1000 * 24 * 60 * 60

        /**
         * 一小时的毫秒数
         */
        const val HOUR_MILLIS = 1000 * 60 * 60

        /**
         * 一分钟的毫秒数
         */
        const val MIN_MILLIS = 1000 * 60

        /**
         * 一秒钟的毫秒数
         */
        const val SEC_MILLIS = 1000
    }
}