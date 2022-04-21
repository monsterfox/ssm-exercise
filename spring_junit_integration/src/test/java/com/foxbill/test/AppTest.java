package com.foxbill.test;

import com.foxbill.config.SpringConfig;
import com.foxbill.pojo.User;
import com.foxbill.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AppTest {
    @Autowired
    private UserService userService;

    @Test
    public void testService() throws IOException {
        List<User> allUser = userService.findAllUser();
        System.out.println(allUser);
    }
}
