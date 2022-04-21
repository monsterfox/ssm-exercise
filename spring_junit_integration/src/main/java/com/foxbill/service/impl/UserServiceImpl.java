package com.foxbill.service.impl;

import com.foxbill.dao.UserDao;
import com.foxbill.pojo.User;
import com.foxbill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAllUser() throws IOException {
        return userDao.findAllUser();
    }

    @Override
    public void addUser(User user) {
        System.out.println("user service addUser...");
        userDao.addUser(user);
    }

    @Override
    public void uptUser(User user) {

    }

    @Override
    public void delUser(int id) {

    }
}
