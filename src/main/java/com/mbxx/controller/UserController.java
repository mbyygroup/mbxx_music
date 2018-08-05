package com.mbxx.controller;

import com.mbxx.pojo.User;
import com.mbxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/add")
    public int addUser(User user){
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
