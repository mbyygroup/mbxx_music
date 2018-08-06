package com.mbxx.dao;

import com.mbxx.pojo.Album;

public interface AlbumMapper {
    int deleteByPrimaryKey(Long albumId);

    int insert(Album record);

    int insertSelective(Album record);

    Album selectByPrimaryKey(Long albumId);

    int updateByPrimaryKeySelective(Album record);

    int updateByPrimaryKey(Album record);
}