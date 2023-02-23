package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List query(){

        List<User> List = userMapper.selectList(null);
        System.out.println(List);
        return List;
    }
    @PostMapping("/user")
    public String save(User user){
        int i = userMapper.insert(user);
        if(i>0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }
}
