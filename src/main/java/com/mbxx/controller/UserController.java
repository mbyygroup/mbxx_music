package com.mbxx.controller;

import com.mbxx.pojo.User;
import com.mbxx.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody
    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum",required = false) int pageNum,
            @RequestParam(name = "pageSize" ,required = false) int pageSize
    ){
        return userService.findAllUser(pageNum,pageSize);
    }

}
