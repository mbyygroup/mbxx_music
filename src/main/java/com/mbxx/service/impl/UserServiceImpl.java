package com.mbxx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mbxx.base.BaseService;
import com.mbxx.dao.UserMapper;
import com.mbxx.pojo.User;
import com.mbxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseService<User> implements UserService {

}
