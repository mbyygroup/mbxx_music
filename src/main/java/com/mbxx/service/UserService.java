package com.mbxx.service;

import com.github.pagehelper.PageInfo;
import com.mbxx.pojo.User;


public interface UserService {

    int addUser(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);
}
