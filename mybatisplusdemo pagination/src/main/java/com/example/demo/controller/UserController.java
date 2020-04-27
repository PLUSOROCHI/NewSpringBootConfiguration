package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author licha
 * @since 2020/4/27 21:14
 */
//后台
@RestController
public class UserController {
    @Autowired
    UserService userService;
    //分页
    //http://localhost:8080/users?start=0
    @GetMapping("/users")
    public IPage<User> findList(@RequestParam(value = "start", defaultValue = "0") int pageNo, @RequestParam(value = "size", defaultValue = "5") int pageSize) {
        IPage<User> page = new Page<>(pageNo, pageSize);
        IPage<User> result=userService.findList(page);
        return result;
    }
}
