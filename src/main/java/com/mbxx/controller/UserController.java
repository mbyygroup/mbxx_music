package com.mbxx.controller;

import com.mbxx.base.Result;
import com.mbxx.constants.BaseEnums;
import com.mbxx.constants.Constants;
import com.mbxx.pojo.User;
import com.mbxx.service.UserService;
import com.mbxx.util.Dates;
import com.mbxx.util.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/add")
    public int addUser(User user){
        logger.info("add开始");
        return userService.addUser(user);
    }


    @GetMapping("/test")
    public String test(){
        logger.info("test启动");
        return "success";
    }

    private static List<User> userList = new ArrayList<>();
    //创建静态测试数据
    static {
        User user1=new User();
        user1.setUserId(1L);
        user1.setUsername("lufei");
        user1.setNickname("蒙奇D路飞");
        user1.setBirthday(Dates.parseDate("2000-05-05"));
        user1.setSex(Constants.Sex.MALE);
        user1.setEnabled(Constants.Flag.YES);
        userList.add(user1);


        User user2 = new User();
        user2.setUserId(2L);
        user2.setUsername("nami");
        user2.setNickname("娜美");
        user2.setBirthday(Dates.parseDate("2000/7/3"));
        user2.setSex(Constants.Sex.FEMALE);
        user2.setEnabled(Constants.Flag.YES);
        userList.add(user2);
    }

    @RequestMapping("/queryAll")
    public Result queryAll(){
         return Results.successWithData(userList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
     }
     @RequestMapping("/queryOne/{userId}")
     public Result queryOne(@PathVariable Long userId){
         User user = null;
         for(User u : userList){
             if(u.getUserId().longValue() == userId){
                 user = u;
             }
         }
         return Results.successWithData(user);
     }
//    @ResponseBody
//    @GetMapping("/all")
//    public Object findAllUser(
//            @RequestParam(name = "pageNum",required = false) int pageNum,
//            @RequestParam(name = "pageSize" ,required = false) int pageSize
//    ){
//        return userService.findAllUser(pageNum,pageSize);
//    }

}
