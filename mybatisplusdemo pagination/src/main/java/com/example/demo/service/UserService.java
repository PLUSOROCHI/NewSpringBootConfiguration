package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service(value="UserService")
public class UserService{
    @Autowired
    public UserMapper userMapper;


    public IPage<User> findList(IPage<User> page)
    {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        IPage<User> result=userMapper.selectPage(page,wrapper);
        return result;
    }
}
