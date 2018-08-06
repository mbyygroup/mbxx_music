package com.mbxx.dao;

import com.mbxx.pojo.User_Singer;

public interface User_SingerMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User_Singer record);

    int insertSelective(User_Singer record);

    User_Singer selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User_Singer record);

    int updateByPrimaryKey(User_Singer record);
}