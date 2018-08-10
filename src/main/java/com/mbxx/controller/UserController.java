package com.mbxx.controller;

import com.mbxx.base.BaseController;
import com.mbxx.base.Result;
import com.mbxx.constants.BaseEnums;
import com.mbxx.pojo.User;
import com.mbxx.service.UserService;
import com.mbxx.util.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/queryAll")
    public Result queryAll(){
         List<User> list=userService.selectAll();
         return Results.successWithData(list, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
     }

     @ResponseBody
     @GetMapping("/queryOne/{userId}")
     public Result queryOne(@PathVariable Long userId){
         User user = userService.get(userId);
         return Results.successWithData(user);
     }

     @PostMapping("/save")
     public Result save(@Valid @RequestBody User user){
        user=userService.insertSelective(user);
        return Results.successWithData(user);
     }

     @PostMapping("/update")
     public Result update(@Valid @RequestBody List<User> user){
        user=userService.update(user);
        return Results.successWithData(user);
     }

     @RequestMapping("/delete")
     public Result delete(User user){
         userService.delete(user);
         return Results.success();
     }

     @RequestMapping("/delete/{userId}")
     public Result delete(@PathVariable Long userId){
         userService.delete(userId);
         return Results.success();
     }





}
