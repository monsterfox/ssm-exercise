package com.foxbill.dao;

import com.foxbill.pojo.User;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    List<User> findAllUser() throws IOException;
    void addUser(User user);
    void uptUser(User user);
    void delUser(int id);
}
