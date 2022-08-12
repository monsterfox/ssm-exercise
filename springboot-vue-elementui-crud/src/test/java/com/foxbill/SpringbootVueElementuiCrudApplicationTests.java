package com.foxbill;

import com.foxbill.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootVueElementuiCrudApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        int row = userMapper.deleteById(11);
        System.out.println(row);
    }

}
