package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

//Spriong的测试环境
@RunWith(SpringRunner.class)
//classes填写项目启动类
@SpringBootTest(classes=DemoApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestClass{
    @Autowired
    UserService userService;


    @Test
    public void test1(){
        //从数据库查询所有用户走数据库 添加cache
        List<User> allUsers=userService.getAllUsers(null);
        for(User user:allUsers){
            System.out.println(user);
        }
    }


    @Test
    public void test2(){
        //添加用户 清除cache
        User a=new User();
        a.setUsername("abcde");
        a.setPassword("qojjdbvdmvkhynbjndc");
        a.setCreateTime("sdbdfv");
        a.setEmail("khjknojmjhg");
        a.setNickname("jhddbfriewqepq");
        userService.addUser(a);
    }

    @Test
    public void test3(){
        //从数据库查询所有用户走数据库 添加cache
        List<User> allUsers=userService.getAllUsers(null);
        for(User user:allUsers){
            System.out.println(user);
        }
    }

    @Test
    public void test4(){
        //从数据库查询所有用户 走cache路线
        List<User> allUsers=userService.getAllUsers(null);
        for(User user:allUsers){
            System.out.println(user);
        }
    }
}
