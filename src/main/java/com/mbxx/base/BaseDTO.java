package com.mbxx.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mbxx.util.Dates;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
* 基础实体类
*
*
* */
public class BaseDTO implements Serializable {
     private static final long serialVersionUID = -4287607489867805101L;
     public static final String FIELD_OPERATE = "operate";
     public static final String FIELD_OBJECT_VERSION_NUMBER = "versionNumber";


     /**
      * 操作类型，add/update/delete 参考：
      */
     @Transient
     private String _operate;

     /**
      * 数据版本号,每发生update则自增,用于实现乐观锁.
      */
     private Long versionNumber;



     public String get_operate() {
         return _operate;
     }

     public void set_operate(String _operate) {
         this._operate = _operate;
     }

    public Integer getVersionNumber() {
        return Math.toIntExact(versionNumber);
    }

    public void setVersionNumber(Long versionNumber) {
        this.versionNumber = versionNumber;
    }


    @Override
     public String toString() {
         return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
     }

     public String toJSONString() {
         return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
     }
}
