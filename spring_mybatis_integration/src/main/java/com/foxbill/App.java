package com.foxbill;

import com.foxbill.pojo.User;
import com.foxbill.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = (UserService) context.getBean("userService");
        List<User> userList = userService.findAllUser();

        System.out.println(userList);

    }
}
