package com.foxbill;

import com.foxbill.config.SpringConfig;
import com.foxbill.dao.UserDao;
import com.foxbill.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class AppForAnnotation {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        UserDao userDao = (UserDao) context.getBean("userDao");
//        UserDao userDao1 = context.getBean(UserDao.class);
//        System.out.println(userDao);
//        System.out.println(userDao1);
//        userDao.addUser(new User());
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource);
    }
}
