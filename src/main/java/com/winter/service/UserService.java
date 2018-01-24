package com.winter.service;

import com.winter.model.User;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author 十一城城主
 * @data 2018/1/22 11:21
 */
public interface UserService {

    int addUser(User user);

    List<User> findAllUser(int pageNum,int pageSize);

    User getUserById(Integer id);

    int deleteUser(User user);

    User updateUser(User user);
}
