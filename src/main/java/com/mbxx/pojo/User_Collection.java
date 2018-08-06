package com.mbxx.pojo;

import java.util.Date;

public class User_Collection {
    private Long collectionId;

    private Long userId;

    private Long singSheetId;

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