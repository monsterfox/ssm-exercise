package com.foxbill;

import com.foxbill.config.SpringConfig;
import com.foxbill.pojo.User;
import com.foxbill.service.UserService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        DataSource ds = context.getBean(DataSource.class);
//        System.out.println(ds);

//        SqlSessionFactoryBean sqlSessionFactoryBean = context.getBean(SqlSessionFactoryBean.class);
//        System.out.println(sqlSessionFactoryBean);

//        SqlSessionFactory sessionFactory = context.getBean(SqlSessionFactory.class);
//        System.out.println(sessionFactory);

        UserService userService = context.getBean(UserService.class);
        List<User> userList = userService.findAllUser();
        System.out.println(userList);

    }
}
