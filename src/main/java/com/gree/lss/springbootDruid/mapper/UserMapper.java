package com.gree.lss.springbootDruid.mapper;

import com.gree.lss.springbootDruid.model.User;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectUsers();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}