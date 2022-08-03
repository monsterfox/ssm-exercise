package com.foxbill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    //请求/save，返回json数据
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    @ResponseBody
    public String save(){
        System.out.println("user save...");
        return "{'msg':'spring mvc'}";
    }

    //请求/get，返回ModelAndView对象
    @RequestMapping("/get")
    public ModelAndView get(){
        ModelAndView mv = new ModelAndView();
        System.out.println("user get...");
        mv.addObject("msg","this msg is use ModelAndView to transfer.");
//        mv.setViewName("WEB-INF/pages/first.jsp"); //在springmvc-config.xml中不配置视图解析器时，使用这个方式指定视图名
        mv.setViewName("first"); //在springmvc-config.xml中配置视图解析器时，使用这个方式指定视图名
        return mv;
    }

    @RequestMapping("/find")
    public String find(Model model){
        System.out.println("user find...");
        model.addAttribute("msg","this msg is use model to transfer");
        return "second";
    }

}
