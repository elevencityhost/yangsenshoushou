package com.winter.mapper;

import com.winter.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
@Mapper
public interface UserMapper {
    static  Logger logger = LoggerFactory.getLogger(UserMapper.class);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //这个方法我自己加的
    List<User> selectAllUser();

    //根据用户id查询用户信息
    User getUserById(Integer id);
}