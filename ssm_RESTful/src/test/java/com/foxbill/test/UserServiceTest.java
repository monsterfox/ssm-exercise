package com.foxbill.test;

import com.foxbill.config.SpringConfig;
import com.foxbill.pojo.User;
import com.foxbill.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void testFindUserById(){
        User user = userService.findUserById(1);
        System.out.println(user);
    }



}
