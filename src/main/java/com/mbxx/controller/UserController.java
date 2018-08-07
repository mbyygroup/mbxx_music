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
        user1.setToId(2L);
        user1.setUsername("lufei");
        user1.setPassword("csgfqge134vsff2q");
        user1.setBirthday(Dates.parseDate("2000-05-05"));
        user1.setSex(Constants.Sex.MALE);
        user1.setLoggin(1);
        user1.setVersionNumber(1);
        user1.setCreateDate(Dates.parseDate("2000-05-05"));
        user1.setBlog("你萌好，愿意永生追随我吗");
        user1.setGotUrl("E:\\ideaUI\\demo\\img\\user_got\\32935-106.jpg");
        userList.add(user1);

        User user2=new User();
        user2.setUserId(2L);
        user2.setToId(1L);
        user2.setUsername("娜美");
        user2.setPassword("csgfqge134vsff2q");
        user2.setBirthday(Dates.parseDate("2000-05-05"));
        user2.setSex(Constants.Sex.MALE);
        user2.setLoggin(1);
        user2.setVersionNumber(1);
        user2.setCreateDate(Dates.parseDate("2000-05-05"));
        user2.setBlog("你萌好，愿意永生追随我吗");
        user2.setGotUrl("E:\\ideaUI\\demo\\img\\user_got\\32935-106.jpg");
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
