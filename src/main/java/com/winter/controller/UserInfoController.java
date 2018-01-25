package com.winter.controller;

import com.winter.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author 十一城城主
 * @data 2018/1/25 11:18
 */
@RestController
@RequestMapping(value = "/userInfo")
public class UserInfoController {

    /**
    　　* 暴露查询用户详情接口
    　　* @author 十一城城主
    　　* @date 2018/1/25 18:06
    　　*/
    @ApiOperation(value = "查询用户详情",notes = "根据用户ID查询用户详细信息")
    @ApiImplicitParam(name = "id",value = "用户ID",dataType = "int",required = true,paramType = "query")
    @PostMapping(value = "/select")
    public String selectNumber(@RequestParam(value = "id",required = true) Integer id ){
        System.out.println(id);
        return id+"";
    }

    /**
    　　* 暴露返回用户实体接口
    　　* @author 十一城城主
    　　* @date 2018/1/25 18:08
    　　*/
    @PostMapping(value = "/responseUser")
    @ApiImplicitParam(name ="user",value = "用户实体",required = true,dataType = "User")
    public User responseUser(@RequestBody User user){
        return user;
    }

}
