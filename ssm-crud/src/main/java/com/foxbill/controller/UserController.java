package com.foxbill.controller;

import com.foxbill.pojo.User;
import com.foxbill.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("list",userService.findAll());
        mv.setViewName("list");
        return mv;
    }

    @RequestMapping("/toAddUser")
    public String toAddUser(){
        return "addUser";
    }

    @RequestMapping("/doAddUser")
    public String doAddUser(User user){
        userService.addUser(user);
        return "redirect:findAll.do";
    }


    @RequestMapping("/toModifyUser")
    public ModelAndView toModifyUser(int id){
        ModelAndView mv = new ModelAndView();
        System.out.println(id);
        System.out.println(userService.getUserById(id));
        mv.addObject("user",userService.getUserById(id));
        mv.setViewName("modifyUser");
        return mv;
    }
    @RequestMapping("/doModifyUser")
    public String doModifyUser(User user){
        userService.modifyUser(user);
        return "redirect:findAll.do";
    }

    @RequestMapping("/doDeleteUser")
    public String doDeleteUser(int id){
        userService.dropUser(id);
        return "redirect:findAll.do";
    }

}
