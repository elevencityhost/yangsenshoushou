package com.winter.controller;

import com.winter.model.User;
import com.winter.service.UserService;
import com.winter.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @author 十一城城主
 * @data 2018/1/22 11:20
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "新增用户",notes = "创建一个新用户")
    @ApiImplicitParam(name = "user",value = "用户详细实体user",required = true,dataType = "User")
    @PostMapping(value = "/add")
    public int addUser(User user){
        return userService.addUser(user);
    }

    @ApiOperation(value = "获取用户列表",notes = "根据页数和页值获取用户列表")
    @GetMapping(value = "/all/{pageNum}/{pageSize}")
    public List<User> findAllUser(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }

    @ApiIgnore
    @RequestMapping(value = "/index")
    public String login(Model model){
        model.addAttribute("name","养森瘦瘦");
        return "/index";
    }
}
