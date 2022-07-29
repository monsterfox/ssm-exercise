package com.foxbill;

import com.foxbill.pojo.User;
import com.foxbill.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUser {
    @Autowired
    IUserService userService;

    @Test
    public void test01(){
        List<User> list = userService.findAll();
        System.out.println(list);
    }

    @Test
    public void test02(){
        User user = userService.getUserById(3);
        System.out.println(user);
    }
}
