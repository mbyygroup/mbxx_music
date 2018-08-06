package com.mbxx.dao;

import com.mbxx.pojo.User_Collection;

public interface User_CollectionMapper {
    int deleteByPrimaryKey(Long collectionId);

    int insert(User_Collection record);

    int insertSelective(User_Collection record);

    User_Collection selectByPrimaryKey(Long collectionId);

    int updateByPrimaryKeySelective(User_Collection record);

    int updateByPrimaryKey(User_Collection record);
}