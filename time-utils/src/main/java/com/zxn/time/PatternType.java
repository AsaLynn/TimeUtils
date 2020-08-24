package com.zxn.time;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Updated by zxn on 2020/8/23.
 */
@StringDef({
        SDFPattern.M_SDF_M,
        SDFPattern.yyyy_SDF_Y,
        SDFPattern.Md_SDF_P,
        SDFPattern.yyyyM_SDF_YM,
        SDFPattern.MMdd_SDF_P,
        SDFPattern.yyyyMMddHHmm_SDF,
        SDFPattern.yyyyMMddHHmmssSSS_SDF,
        SDFPattern.MMddHHmmSS_SDF_RCC,
        SDFPattern.yyyyMMdd_SDF_PP,
        SDFPattern.yyyyMMddHHmm_SDF_PPC,
        SDFPattern.yyyyMMddHHCmmCss_SDF_PPCC,
        SDFPattern.yyMMddHHmmssSSS_SDF,
        SDFPattern.yyyyMMddHHmmss_SDF,
        SDFPattern.yyyyMMdd_SDF,
        SDFPattern.yyyyMMddHHmm_SDF_RRC,
        SDFPattern.yyyyMMddHH_SDF_RR,
        SDFPattern.yyyyMM_SDF_R,
        SDFPattern.MMddHHmm_SDF_RC,
        SDFPattern.HHmmSS_SDF_CC,
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
        SDFPattern.HHmmss_SDF,
        SDFPattern.HHmm_SDF,
        SDFPattern.MMdd_SDF_R,
        SDFPattern.yyyyMMdd_SDF_SPSP,
        SDFPattern.yyyyMMdd_SDF_RR,
        SDFPattern.yyyyMMddHHmmSS_SDF_SPSPCC,
        SDFPattern.yyyyMMddHHmmSS_SDF_RRCC,})
@Retention(RetentionPolicy.SOURCE)
public @interface PatternType {

}
