package com.gree.lss.springbootDruid.service;

import com.github.pagehelper.Page;
import com.gree.lss.springbootDruid.model.User;

import java.util.List;

public interface UserService {

    int addUser(User user);

    List<User> findAllUser(Page page);
}
