package com.foxbill.dao.impl;

import com.foxbill.dao.UserDao;
import com.foxbill.pojo.User;

import java.io.IOException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAllUser() throws IOException {
        return null;
    }

    @Override
    public void addUser(User user) {
        System.out.println("user...addUser...");
    }

    @Override
    public void uptUser(User user) {

    }

    @Override
    public void delUser(int id) {

    }
}
