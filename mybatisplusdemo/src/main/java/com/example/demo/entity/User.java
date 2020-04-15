package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@TableName(value="user")
public class User{
    @TableId(value="id",type=IdType.AUTO)
    int id;
    String username;
    String password;
    String nickname;
    String email;
    String createTime;//不是String create_time;
//默认mybatisplus 识别数据库下划线字段 需要在实体类使用驼峰式写法
}

