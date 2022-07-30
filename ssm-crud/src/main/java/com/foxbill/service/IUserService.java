package com.foxbill.service;

import com.foxbill.pojo.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    boolean addUser(User user);
    boolean modifyUser(User user);
    boolean modifyUserNoImg(User user);
    boolean dropUser(int id);
    User getUserById(int id);
}
