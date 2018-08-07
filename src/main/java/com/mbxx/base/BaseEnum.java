package com.mbxx.base;

public interface BaseEnum<K,V> {
    //获取编码
    K code();

    //获取描述
    V desc();
}
