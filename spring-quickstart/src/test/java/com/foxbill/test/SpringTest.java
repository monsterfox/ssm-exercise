package com.foxbill.test;

import com.foxbill.pojo.User;
import com.foxbill.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class SpringTest {
    @Test
    public void testAddUser() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        userService.addUser(new User());
    }

    @Test
    public void testDataSource(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object dataSource = context.getBean("dataSource");
        System.out.println(dataSource);
    }
}
