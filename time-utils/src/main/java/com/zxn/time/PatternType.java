package com.zxn.time;

import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by zxn on 2019/5/15.
 */

@StringDef({
        SDFPattern.MMdd_SDF_P,
        SDFPattern.yyyyMMddHHmm_SDF,
        SDFPattern.yyyyMMddHHmmssSSS_SDF,
        SDFPattern.MMRddHHCmmCSS_SDF,
        SDFPattern.yyyyMMdd_SDF_PP,
        SDFPattern.yyyyMMddHHmm_SDF_PPC,
        SDFPattern.yyyyMMddHHCmmCss_SDF_PPCC,
        SDFPattern.yyMMddHHmmssSSS_SDF,
        SDFPattern.yyyyMMddHHmmss_SDF,
        SDFPattern.yyyyMMdd_SDF,
        SDFPattern.yyyyMMddHHmm_SDF_RRC,
        SDFPattern.yyyyMMddHH_SDF_RR,
        SDFPattern.yyyyMM_SDF_R,
        SDFPattern.MMRddHHCmm_SDF,
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
        SDFPattern.MMRdd_SDF,
        SDFPattern.yyyySPMMSPdd_SDF,
        SDFPattern.yyyyRMMRdd_SDF,
        SDFPattern.yyyySPMMSPddHHCmmCSS_SDF,
        SDFPattern.yyyyRMMRddHHCmmCSS_SDF,})
@Retention(RetentionPolicy.SOURCE)
public @interface PatternType {

}
