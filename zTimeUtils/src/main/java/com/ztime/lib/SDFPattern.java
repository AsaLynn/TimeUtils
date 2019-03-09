package com.ztime.lib;

/**
 * 24小时制时间格式,SDFPattern(SDFPattern12)
 * Created by zxn on 2019/2/28.
 */
public final class SDFPattern {

    //SDF_(R(rod)-->-),(C(colon)-->:),(Y(year)-->年),(M(month)-->月),(D(day)-->日),(P(point)-->.)

    /**
     * 类型为24小时制日期格式:yyyy-MM-dd HH:mm:ss.
     */
    public static final String yyyyMMddHHmmSS_SDF_RRCC = "yyyy-MM-dd HH:mm:ss";

    /**
     * 类型为24小时制日期格式:yyyy-MM-dd HH:mm.
     */
    public static final String yyyyMMddHHmm_SDF_RRC = "yyyy-MM-dd HH:mm";

    /**
     * 类型为24小时制日期格式:yyyy-MM-dd HH.
     */
    public static final String yyyyMMddHH_SDF_RR = "yyyy-MM-dd HH";

    /**
     * 类型为24小时制日期格式:yyyy-MM-dd.
     */
    public static final String yyyyMMdd_SDF_RR = "yyyy-MM-dd";

    /**
     * 类型为24小时制日期格式:yyyy-MM.
     */
    public static final String yyyyMM_SDF_R = "yyyy-MM";

    /**
     * 类型为24小时制日期格式:MM-dd.
     */

    public static final String MMdd_SDF_R = "MM-dd";



    /**
     * 类型为24小时制日期格式:HH:mm:ss.
     */
    public static final String HHmmSS_SDF_CC = "HH:mm:ss";



    /**
     * 类型为24小时制日期格式:yyyy.MM.dd HH:mm.
     */
    public static final String yyyyMMddHHmm_SDF_PPC = "yyyy.MM.dd HH:mm";



    /**
     * 类型为24小时制日期格式:HH:mm.
     */
    public static final String HHmm_SDF_C = "HH:mm";


    /**
     * 类型为24小时制日期格式:yyyy年MM月dd日 HH:mm:ss.
     */
    public static final String yyyyMMddHHmmSS_SDF_YMDCC = "yyyy年MM月dd日 HH:mm:ss";



    /**
     * 类型为24小时制日期格式:yyyy年M月d日 HH:mm:ss
     */
    public static final String yyyyMdHHmmSS_SDF_YMDCC = "yyyy年M月d日 HH:mm:ss";



    /**
     * 类型为24小时制日期格式:yyyy年M月d日 HH:mm
     */
    public static final String yyyyMdHHmm_SDF_YMDC = "yyyy年M月d日 HH:mm";



    /**
     * 类型为24小时制日期格式:yyyy年MM月dd日
     */
    public static final String yyyyMMdd_SDF_YMD = "yyyy年MM月dd日";



    /**
     * 类型为24小时制日期格式:yyyy年M月d日
     */
    public static final String yyyyMd_SDF_YMD = "yyyy年M月d日";



    /**
     * 类型为24小时制日期格式:MM月dd日
     */
    public static final String MMdd_SDF_MD = "MM月dd日";

//    /**
//     * 类型为24小时制日期格式:MM月dd日
//     */
//    @Deprecated
//    public static final String Md_SDF_MD = "MM月dd日";

    /**
     * 类型为24小时制日期格式:M月d日
     */
    public static final String Md_SDF_MD = "M月d日";


    /**
     * 类型为24小时制日期格式:yyyy年MM月dd日 HH:mm:ss.---C(:)
     */
    public static final String MMddHHmmSS_SDF_MDCC = "MM月dd日 HH:mm:ss";



    /**
     * 类型为24小时制日期格式:M月d日 HH:mm:ss
     */
    public static final String MdHHmmSS_SDF_MDCC = "M月d日 HH:mm:ss";



    /**
     * 类型为24小时制日期格式:M月d日 HH:mm
     */
    public static final String MdHHmm_SDF_MDC = "M月d日 HH:mm";





    //------------------------------以下常量过时废弃------------------------------------------------

    /**
     * 类型为24小时制日期格式:yyyy年M月d日 HH:mm
     */
    @Deprecated
    public static final String yM1d1HHmm_SDF_NYR = "yyyy年M月d日 HH:mm";

    /**
     * 类型为24小时制日期格式:yyyy年MM月d日 HH:mm:ss.
     */
    @Deprecated
    public static final String yMd1HmS_SDF_NYR = "yyyy年MM月d日 HH:mm:ss";

    /**
     * 类型为24小时制日期格式:yyyy年MM月dd日
     */
    @Deprecated
    public static final String yMd_SDF_NYR = "yyyy年MM月dd日";

    /**
     * 类型为24小时制日期格式:yyyy年M月d日
     */
    @Deprecated
    public static final String yM1d1_SDF_NYR = "yyyy年M月d日";

    /**
     * 类型为24小时制日期格式:yyyy年MM月d日
     */
    @Deprecated
    public static final String yMd1_SDF_NYR = "yyyy年MM月d日";

    /**
     * 类型为24小时制日期格式:M月d日
     */
    @Deprecated
    public static final String M1d1_SDF_YR = "M月d日";

    /**
     * 类型为24小时制日期格式:yyyy年MM月dd日 HH:mm:ss.
     */
    @Deprecated
    public static final String MdHmS_SDF_YR = "MM月dd日 HH:mm:ss";

    /**
     * 类型为24小时制日期格式:M月d日 HH:mm:ss
     */
    @Deprecated
    public static final String M1d1HmS_SDF_YR = "M月d日 HH:mm:ss";

    /**
     * 类型为24小时制日期格式:M月d日 HH:mm
     */
    @Deprecated
    public static final String M1d1HHmm_SDF_YR = "M月d日 HH:mm";

    /**
     * 类型为24小时制日期格式:yyyy-MM-dd HH:mm:ss.
     */
    @Deprecated
    public static final String yMdHmS_SDF = "yyyy-MM-dd HH:mm:ss";

    /**
     * 类型为24小时制日期格式:yyyy-MM-dd HH:mm.
     */
    @Deprecated
    public static final String yMdHm_SDF = "yyyy-MM-dd HH:mm";

    /**
     * 类型为24小时制日期格式:yyyy-MM-dd HH.
     */
    @Deprecated
    public static final String yMdH_SDF = "yyyy-MM-dd HH";

    /**
     * 类型为24小时制日期格式:yyyy-MM-dd.
     */
    @Deprecated
    public static final String yMd_SDF = "yyyy-MM-dd";

    /**
     * 类型为24小时制日期格式:yyyy-MM.
     */
    @Deprecated
    public static final String yM_SDF = "yyyy-MM";

    /**
     * 类型为24小时制日期格式:yyyy年M月d日 HH:mm:ss
     */
    @Deprecated
    public static final String yM1d1HmS_SDF_NYR = "yyyy年M月d日 HH:mm:ss";

    /**
     * 类型为24小时制日期格式:MM-dd.
     */
    @Deprecated
    public static final String Md_SDF = "MM-dd";

    /**
     * 类型为24小时制日期格式:yyyy.MM.dd HH:mm.
     */
    @Deprecated
    public static final String yMdHm_SDF_POIONT = "yyyy.MM.dd HH:mm";
    /**
     * 类型为24小时制日期格式:HH:mm.
     */
    @Deprecated
    public static final String Hm_SDF = "HH:mm";

    /**
     * 类型为24小时制日期格式:yyyy年MM月dd日 HH:mm:ss.
     */
    @Deprecated
    public static final String yMdHmS_SDF_NYR = "yyyy年MM月dd日 HH:mm:ss";

    /**
     * 类型为24小时制日期格式:HH:mm:ss.
     */
    @Deprecated
    public static final String HmS_SDF = "HH:mm:ss";


}
