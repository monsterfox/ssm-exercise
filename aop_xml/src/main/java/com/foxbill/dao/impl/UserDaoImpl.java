package com.foxbill.dao.impl;

import com.foxbill.dao.UserDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
//        System.out.println(System.currentTimeMillis());
        System.out.println("user dao save ...");
    }

    @Override
    public void update() {
        System.out.println("user dao update ...");
    }
}
