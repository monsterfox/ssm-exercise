package com.foxbill.service;

import com.foxbill.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserService {
    List<User> findAllUser();

    User findUserById(Integer id);
    boolean addUser(User user);

    boolean uptUser(User user);

    boolean delUser(int id);
}
