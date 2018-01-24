package com.winter.service.impl;

import com.github.pagehelper.PageHelper;
import com.winter.mapper.UserMapper;
import com.winter.model.User;
import com.winter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 十一城城主
 * @data 2018/1/22 11:22
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法
        PageHelper.startPage(pageNum,pageSize);
        return userMapper.selectAllUser();
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteUser(User user) {
        return userMapper.deleteByPrimaryKey(user.getUserId());
    }

    @Override
    public User updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        User user1 = userMapper.selectByPrimaryKey(user.getUserId());
        return user1;
    }
}
