package com.foxbill;

import com.foxbill.dao.UserDao;
import com.foxbill.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml.bak");
        UserDao userDao = (UserDao) context.getBean("userDao");
        UserDao userDao1 = context.getBean(UserDao.class);
        System.out.println(userDao);
        System.out.println(userDao1);
        userDao.addUser(new User());
    }
}
