package com.foxbill.controller;

import com.foxbill.mapper.UserMapper;
import com.foxbill.pojo.User;
import com.foxbill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @RequestMapping("/getusers")
    public List<User> getAll(){
        List<User> list = userService.list(null);
        return list;
    }

    @RequestMapping("/adduser")
    public boolean addUser(@RequestBody User user){
        //int row = userMapper.insert(user);
        boolean save = userService.save(user);
        return save;
    }

    @RequestMapping("/uptuser")
    public boolean uptUser(@RequestBody User user){
        boolean update = userService.saveOrUpdate(user);
        return update;
    }

    @RequestMapping("/deluser")
    public boolean delUser(@RequestBody User user){
        boolean remove = userService.removeById(user);
        return remove;
    }
}
