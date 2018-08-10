package com.mbxx.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mbxx.util.Dates;

import javax.persistence.*;
import java.util.Date;

//关注表
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "USER_CONCERN")
public class User_Concern {

    private static final long serialVersionUID = -7395431342734009038L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderBy("DESC")
    private Long concernId;

    private Long userId;

    private Long concrenId;

    @JsonFormat(pattern = Dates.Pattern.DATE)
    private Date createTime;

    public Long getConcernId() {
        return concernId;
    }

    public void setConcernId(Long concernId) {
        this.concernId = concernId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getConcrenId() {
        return concrenId;
    }

    public void setConcrenId(Long concrenId) {
        this.concrenId = concrenId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}