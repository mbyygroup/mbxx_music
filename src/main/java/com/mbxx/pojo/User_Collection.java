package com.mbxx.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mbxx.util.Dates;

import javax.persistence.*;
import java.util.Date;

//收藏表
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "USER_COLLECTION")
public class User_Collection {

    private static final long serialVersionUID = -7395451342736009038L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderBy("DESC")
    private Long collectionId;

    private Long userId;

    private Long singSheetId;

    @JsonFormat(pattern = Dates.Pattern.DATE)
    private Date createTime;

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSingSheetId() {
        return singSheetId;
    }

    public void setSingSheetId(Long singSheetId) {
        this.singSheetId = singSheetId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}