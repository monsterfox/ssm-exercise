package com.foxbill.controller;

import com.foxbill.mapper.UserMapper;
import com.foxbill.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getusers")
    public List<User> getAll(){
        List<User> list = userMapper.selectList(null);
        return list;
    }

    @RequestMapping("/adduser")
    public int addUser(@RequestBody User user){
        int row = userMapper.insert(user);
        return row;
    }

    @RequestMapping("/uptuser")
    public int uptUser(@RequestBody User user){
        int row = userMapper.updateById(user);
        return row;
    }

    @RequestMapping("/deluser")
    public int delUser(@RequestBody User user){
        int row = userMapper.deleteById(user);
        return row;
    }
}
