package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ForeRESTController{
    @Autowired
    UserService userService;

    //http://localhost:8080/userlist
    @GetMapping("/userlist")
    public List<User> list(){
        List<User> allUsers=userService.getAllUsers(null);

        return allUsers;
    }

    //http://localhost:8080/register
    /*
    {
        "username": "user6",
        "password": "sLrunSedNPod/XGq25CMPw==",
        "nickname": "tgdvdfvfbhhnjcsd",
        "email": "sadadfgtrvgr",
        "createTime": "2020-04-19 10:11:19"
    }
    */
    @PostMapping("/register")
    public void register(@RequestBody User user){
        userService.addUser(user);
    }
}