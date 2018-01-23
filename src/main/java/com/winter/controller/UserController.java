package com.winter.controller;

import com.winter.model.User;
import com.winter.service.UserService;
import com.winter.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 十一城城主
 * @data 2018/1/22 11:20
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/add")
    @ResponseBody
    public int addUser(User user){
        return userService.addUser(user);
    }

    @GetMapping(value = "/all/{pageNum}/{pageSize}")
    @ResponseBody
    public List<User> findAllUser(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }

    @RequestMapping(value = "/index")
    public String login(){
        return "/index";
    }
}
