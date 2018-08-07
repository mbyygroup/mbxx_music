package com.mbxx.util;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 日期时间工具类
*
*
* */
public class Dates {
    //日期时间匹配格式
    public interface Pattern{
        String DATE="yyyy-MM-dd";
        String DATETIME="yyyy-MM-dd HH:mm:ss";
        String DATETIME_MM="yyyy-MM-dd HH:mm";
        String DATETIME_SSS="yyyy-MM-dd HH:mm:ss.SSS";
        String TIME="HH:mm";
        String TIME_SS="HH:mm:ss";

        //系统时间格式
        String SYS_DATE="yyy/MM/dd";
        String SYS_DATETIME="yyyy/MM/dd HH:mm:ss";
        String SYS_DATETIME_MM="yyyy/MM/dd HH:mm";
        String SYS_DATETIME_SSS="yyyy/MM/dd HH:mm:ss.SSS";

        //无连接符模式
        String NONE_DATE="yyyyMMdd";
        String NONE_DATETIME="yyyyMMddHHmmss";
        String NONE_DATETIME_MM="yyyyMMddHHmm";
        String NONE_DATETIME_SSS="yyytMMddHHmmssSSS";
    }

    public static final String DEFAULT_PATTERN=Pattern.DATETIME;

    public static final String[] PARSE_PATTERNS=new String[]{
            Pattern.DATE,
            Pattern.DATETIME,
            Pattern.DATETIME_MM,
            Pattern.DATETIME_SSS,
            Pattern.SYS_DATE,
            Pattern.SYS_DATETIME,
            Pattern.SYS_DATETIME_MM,
            Pattern.SYS_DATETIME_SSS
    };

    //格式化日期时间
    public static String format(Date date){
        return format(date,DEFAULT_PATTERN);
    }

    //格式化日期
    public static String format(Date date,String pattern){
        if(date==null){
            return null;
        }
        pattern= StringUtils.isNotBlank(pattern)?pattern:DEFAULT_PATTERN;
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    //解析日期
    public static Date parseDate(String date){
        if(StringUtils.isBlank(date)){
            return null;
        }
        try {

            return DateUtils.parseDate(date,PARSE_PATTERNS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parseDate(String date,String pattern){
        if(StringUtils.isBlank(date)){
            return null;
        }
        String[] parsePatterns;
        parsePatterns=StringUtils.isNotBlank(pattern) ? new String[]{pattern} :PARSE_PATTERNS;
        try {
            return DateUtils.parseDate(date,parsePatterns);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }



}
