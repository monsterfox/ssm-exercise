package com.foxbill.service.impl;

import com.foxbill.mapper.UserMapper;
import com.foxbill.pojo.User;
import com.foxbill.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public boolean modifyUser(User user) {
        return userMapper.modifyUser(user);
    }

    @Override
    public boolean modifyUserNoImg(User user) {
        return userMapper.modifyUserNoImg(user);
    }

    @Override
    public boolean dropUser(int id) {
        return userMapper.dropUser(id);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
