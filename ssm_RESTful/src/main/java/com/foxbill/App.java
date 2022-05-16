package com.foxbill;

import com.foxbill.config.SpringConfig;
import com.foxbill.config.SpringMvcConfig;
import com.foxbill.controller.UserController;
import com.foxbill.mapper.UserMapper;
import com.foxbill.pojo.User;
import com.foxbill.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        System.out.println(context);

//        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
//        webApplicationContext.register(SpringMvcConfig.class);
//        UserController userController = webApplicationContext.getBean(UserController.class);
//        System.out.println(userController);

        UserService userService = context.getBean(UserService.class);
        List<User> userList = userService.findAllUser();
        System.out.println(userList);


    }
}
