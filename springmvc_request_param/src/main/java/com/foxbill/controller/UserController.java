package com.foxbill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/save")
    @ResponseBody
    public String save(String name){
        System.out.println("user...save..");
        System.out.println(name);
        return "{'msg':'hello springmvc'}";
    }
}
