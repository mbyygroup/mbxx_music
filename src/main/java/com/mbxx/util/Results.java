package com.mbxx.util;

import com.mbxx.base.Result;

//Results生成工具类
public class Results {
    protected Results() {}

    public static Result newResult(){
        return new Result();
    }

    public static Result newResult(boolean success){
        return new Result(success);
    }

    //业务调用成功
    public static Result success(){
        return new Result();
    }

    public static Result success(String msg){
        return new Result(true,null,msg);
    }

    public static Result success(String code,String msg){
        return new Result(true,code,msg);
    }

    public static Result successWithStatus(Integer status){
        return new Result(true,status);
    }

    public static Result successWithStatus(Integer status,String msg){
        return new Result(true,status,null,msg);
    }

    public static Result successWithData(Object data){
        return new Result(true,null,null,data);
    }

    public static Result successWithData(Object data, String msg) {
         return new Result(true, null, msg, data);
     }

     public static Result successWithData(Object data, String code, String msg) {
         return new Result(true, code, msg, data);
     }

}
