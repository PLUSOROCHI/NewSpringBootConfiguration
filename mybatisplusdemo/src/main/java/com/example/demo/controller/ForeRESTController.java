package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ForeRESTController{
    @Autowired
    UserService userService;

    //http://localhost:8080/userlist
    @GetMapping("/userlist")
    public void list(){
        List<User> allUsers=userService.getAllUsers(null);
        for(User user:allUsers){
            System.out.println(user);
        }
    }
}