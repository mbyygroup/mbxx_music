package com.mbxx.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

//专辑列表
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "ALBUM")
public class Album {

    private static final long serialVersionUID = -7395431342736009038L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderBy("DESC")
    private Long albumId;

    private String albumName;

    private Long singerId;

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    public Long getSingerId() {
        return singerId;
    }

    public void setSingerId(Long singerId) {
        this.singerId = singerId;
    }
}