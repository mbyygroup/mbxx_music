package com.mbxx.dao;

import com.mbxx.pojo.User_Concern;

public interface User_ConcernMapper {
    int deleteByPrimaryKey(Long concernId);

    int insert(User_Concern record);

    int insertSelective(User_Concern record);

    User_Concern selectByPrimaryKey(Long concernId);

    int updateByPrimaryKeySelective(User_Concern record);

    int updateByPrimaryKey(User_Concern record);
}