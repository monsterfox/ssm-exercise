package com.foxbill.service.impl;

import com.foxbill.mapper.UserMapper;
import com.foxbill.pojo.User;
import com.foxbill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUser()  {
        return userMapper.findAllUser();
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.findUserById(id);
    }

    @Override
    public boolean addUser(User user) {
        userMapper.addUser(user);
        return true;
    }

    @Override
    public boolean uptUser(User user) {
        userMapper.uptUser(user);
        return true;
    }

    @Override
    public boolean delUser(int id) {
        userMapper.delUser(id);
        return true;
    }
}
