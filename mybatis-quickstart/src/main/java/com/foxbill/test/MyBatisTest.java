package com.foxbill.test;

import com.foxbill.mapper.UserMapper;
import com.foxbill.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
//        List<User> userList = sqlSession.selectList("test.findAllUser");

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(userMapper);
        List<User> userList = userMapper.findAllUser();
        System.out.println(userList);

//        User user = new User();
//        user.setId(15);
//        user.setUsername("22");
//        user.setSex("22");
//        user.setAge(22);

//        userMapper.addUser(user);
//        userMapper.uptUser(user);
//        userMapper.delUser(14);
//        sqlSession.commit();

    }
}
