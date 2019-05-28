package com.ztime.lib;

/**
 * 24小时制时间格式,SDFPattern(SDFPattern12)
 * Created by zxn on 2019/2/28.
 */
public interface SDFPattern {

    //SDF_(SP(sprit)-->"/"),(R(rod)-->"-"),(C(colon)-->":"),(Y(year)-->"年"),(M(month)-->"月"),(D(day)-->"日"),(P(point)-->".")
    /**
     * 20190403105532000
     * 类型为24小时制日期格式:yyyyMMddHHmmssSSS.
     */
    String yyyyMMddHHmmssSSS_SDF = "yyyyMMddHHmmssSSS";

    /**
     * 20190403105532
     * 类型为24小时制日期格式:yyyyMMddHHmmss.
     */
    String yyyyMMddHHmmss_SDF = "yyyyMMddHHmmss";

    /**
     * 20190523.
     * 类型为24小时制日期格式:yyyyMMdd.
     */
    String yyyyMMdd_SDF = "yyyyMMdd";

    /**
     * 194800
     * 类型为24小时制日期格式:HHmmss.
     */
    String HHmmss_SDF = "HHmmss";

    /**
     * 2019/04/03
     * 类型为24小时制日期格式:yyyy/MM/dd.
     */
    String yyyySPMMSPdd_SDF = "yyyy/MM/dd";

    /**
     * 类型为24小时制日期格式:yyyy-MM-dd HH:mm:ss.
     */
    String yyyyRMMRddHHCmmCSS_SDF = "yyyy-MM-dd HH:mm:ss";

    /**
     * 类型为24小时制日期格式:yyyy-MM-dd HH:mm.
     */
    String yyyyMMddHHmm_SDF_RRC = "yyyy-MM-dd HH:mm";

    /**
     * 类型为24小时制日期格式:yyyy-MM-dd HH.
     */
    String yyyyMMddHH_SDF_RR = "yyyy-MM-dd HH";


    /**
     * 类型为24小时制日期格式:yyyy-MM-dd.
     */
    String yyyyRMMRdd_SDF = "yyyy-MM-dd";

    /**
     * 类型为24小时制日期格式:yyyy-MM.
     */
    String yyyyMM_SDF_R = "yyyy-MM";


    /**
     * 类型为24小时制日期格式:MM-dd HH:mm.
     */
    String MMRddHHCmm_SDF = "MM-dd HH:mm";

    /**
     * 类型为24小时制日期格式:MM-dd.
     */
    String MMRdd_SDF = "MM-dd";


    /**
     * 类型为24小时制日期格式:HH:mm:ss.
     */
    String HHmmSS_SDF_CC = "HH:mm:ss";


    /**
     * 类型为24小时制日期格式:yyyy.MM.dd HH:mm.
     */
    String yyyyMMddHHmm_SDF_PPC = "yyyy.MM.dd HH:mm";


    /**
     * 类型为24小时制日期格式:HH:mm.
     */
    String HHmm_SDF_C = "HH:mm";


    /**
     * 类型为24小时制日期格式:yyyy年MM月dd日 HH:mm:ss.
     */
    String yyyyMMddHHmmSS_SDF_YMDCC = "yyyy年MM月dd日 HH:mm:ss";


    /**
     * 类型为24小时制日期格式:yyyy年M月d日 HH:mm:ss
     */
    String yyyyMdHHmmSS_SDF_YMDCC = "yyyy年M月d日 HH:mm:ss";


    /**
     * 类型为24小时制日期格式:yyyy年M月d日 HH:mm
     */
    String yyyyMdHHmm_SDF_YMDC = "yyyy年M月d日 HH:mm";


    /**
     * 类型为24小时制日期格式:yyyy年MM月dd日
     */
    String yyyyMMdd_SDF_YMD = "yyyy年MM月dd日";


    /**
     * 类型为24小时制日期格式:yyyy年M月d日
     */
    String yyyyMd_SDF_YMD = "yyyy年M月d日";


    /**
     * 类型为24小时制日期格式:MM月dd日
     */
    String MMdd_SDF_MD = "MM月dd日";

    /**
     * 类型为24小时制日期格式:M月d日
     */
    String Md_SDF_MD = "M月d日";


    /**
     * 类型为24小时制日期格式:yyyy年MM月dd日 HH:mm:ss.---C(:)
     */
    String MMddHHmmSS_SDF_MDCC = "MM月dd日 HH:mm:ss";


    /**
     * 类型为24小时制日期格式:M月d日 HH:mm:ss
     */
    String MdHHmmSS_SDF_MDCC = "M月d日 HH:mm:ss";


    /**
     * 类型为24小时制日期格式:M月d日 HH:mm
     */
    String MdHHmm_SDF_MDC = "M月d日 HH:mm";


}
