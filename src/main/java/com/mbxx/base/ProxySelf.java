package com.mbxx.base;

import org.springframework.aop.framework.AopContext;

//获取代理对象本身
public interface ProxySelf<T> {

    //取得当前对象的代理
    @SuppressWarnings("unchecked")
    default T self(){
        return (T) AopContext.currentProxy();
    }
}
