package com.mbxx.constants;

import com.google.common.base.Charsets;

import java.nio.charset.Charset;

/*
* 系统级常量类
*
*
* */
public class Constants {
    public static final String APP_NAME="mbxx_music";

    /*
    *
    *系统编码/
     */
    public static final Charset CHARSET= Charsets.UTF_8;

    /*
    * 标识
    *
    * */
    public interface Flag{
        Integer YES=1;
        Integer NO=0;
    }

    /*
    * 操作类型
    *
    *
    * */
    public interface Operation {
        String ADD="add";
        String UPDATE="update";
        String DELETE="delete";
    }

    /*
    * 性别
    *
    * */
    public interface Sex{
        Integer MALE=1;
        Integer FEMALE=0;
    }
}
