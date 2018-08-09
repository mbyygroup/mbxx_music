package com.mbxx.controller;

import com.mbxx.base.BaseController;
import com.mbxx.base.Result;
import com.mbxx.constants.BaseEnums;
import com.mbxx.pojo.User;
import com.mbxx.service.UserService;
import com.mbxx.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryAll")
    public Result queryAll(){
         List<User> list=userService.selectAll();
         return Results.successWithData(list, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
     }

     @RequestMapping("/queryOne/{userId}")
     public Result queryOne(@PathVariable Long userId){
         User user = userService.get(userId);
         return Results.successWithData(user);
     }




}
