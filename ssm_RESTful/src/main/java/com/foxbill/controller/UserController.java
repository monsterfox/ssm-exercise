package com.foxbill.controller;

import com.foxbill.pojo.User;
import com.foxbill.service.UserService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
//    @Qualifier("userService")
    private UserService userService;

    @PostMapping
    public String save(@RequestBody User user){
        System.out.println(user);
        userService.addUser(user);
        return "{'module':'user save success'}";
    }

    @GetMapping
    public List<User> getAll(){
        System.out.println("get all users.....");
        List<User> list = userService.findAllUser();
        return list;
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Integer id) {
        return userService.findUserById(id);
    }

    @PutMapping
    public boolean uptUser(@RequestBody User user) {
        return userService.uptUser(user);
    }

    @DeleteMapping("/{id}")
    public boolean delUser(@PathVariable int id) {
        return userService.delUser(id);
    }
}
