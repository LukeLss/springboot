package com.gree.lss.springbootDruid.controller;

import com.github.pagehelper.Page;
import com.gree.lss.springbootDruid.model.User;
import com.gree.lss.springbootDruid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("add")
    public int add(User user) {
        return userService.addUser(user);
    }

    @GetMapping("users")
    public Object users(int pageNum,int pageSize) {
        Page page = new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        return userService.findAllUser(page);
    }
}
