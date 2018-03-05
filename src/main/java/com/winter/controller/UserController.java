package com.winter.controller;

import com.winter.model.User;
import com.winter.service.UserService;
import com.winter.service.impl.UserServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
    public int addUser(@RequestBody User user){
        System.out.println(user);
        return userService.addUser(user);
    }

    @ApiOperation(value = "获取用户列表",notes = "根据页数和页值获取用户列表")
    @GetMapping(value = "/all/{pageNum}/{pageSize}")
    public List<User> findAllUser(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize){
        return userService.findAllUser(pageNum,pageSize);
    }

    @ApiOperation(value = "删除用户",notes = "根据用户id将其删除")
    @DeleteMapping(value = "/deleteUser")
    public int deleteUser(@RequestParam(value = "userId",required = false) Integer id){
        User user = userService.getUserById(id);
        System.out.println(user.toString());
        if (user!=null){
            System.out.println(userService.deleteUser(user));
            return 1;
        }
        return 0;
    }

    @ApiOperation(value = "更新用户信息",notes = "根据url的id来指定更新对象,并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户ID",required = true,dataType = "int",paramType = "path"),
            @ApiImplicitParam(name = "user",value = "用户详细实体user",required = true,dataType = "User")
    })
    @PutMapping(value = "/updateUser/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user){
        System.out.println(user);
       return userService.updateUser(user);
    }
    
    @ApiIgnore
    @RequestMapping(value = "/index")
    public String login(Model model){
        model.addAttribute("name","养森瘦瘦");
        return "/index";
    }
}
