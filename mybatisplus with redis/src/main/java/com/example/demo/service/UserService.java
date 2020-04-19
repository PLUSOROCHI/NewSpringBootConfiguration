package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@CacheConfig(cacheNames="users")
@Service(value="UserService")
public class UserService{
    @Autowired
    public UserMapper userMapper;

    @Cacheable(value="Alluser",key="'users-all'")
    public List<User> getAllUsers(QueryWrapper<User>wrapper){
        System.out.println("querying in database!adding cache");
        return userMapper.selectList(wrapper);
    }

    @CacheEvict(value="Alluser",allEntries = true)
    public void addUser(User user)
    {
        System.out.println("clear cache!");
        userMapper.insert(user);
    }
}
