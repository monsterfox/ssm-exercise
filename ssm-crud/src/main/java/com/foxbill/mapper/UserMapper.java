package com.foxbill.mapper;

import com.foxbill.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
    boolean addUser(User user);
    boolean modifyUser(User user);
    boolean dropUser(int id);
    User getUserById(int id);
}
