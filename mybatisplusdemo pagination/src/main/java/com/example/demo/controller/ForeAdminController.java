package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author licha
 * @since 2020/4/27 21:17
 */
@Controller
public class ForeAdminController {
    //http://localhost:8080/admin
    //后台首页跳转
    @GetMapping(value="/admin")
    public String admin(){
        return "redirect:admin_user_list";
    }

    //http://localhost:8080/admin/listUser
    //用户跳转
    @GetMapping(value="/admin_user_list")
    public String listUser(){
        return "admin/listUser";
    }

}
