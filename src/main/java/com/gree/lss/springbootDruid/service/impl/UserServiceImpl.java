package com.gree.lss.springbootDruid.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gree.lss.springbootDruid.mapper.UserMapper;
import com.gree.lss.springbootDruid.model.User;
import com.gree.lss.springbootDruid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> findAllUser(Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return userMapper.selectUsers();
    }
}
