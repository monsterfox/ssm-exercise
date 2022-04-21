package com.foxbill.dao;

import com.foxbill.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.io.IOException;
import java.util.List;

public interface UserDao {
    @Select("select * from t_user")
    List<User> findAllUser() throws IOException;

    @Insert("insert into t_user values(null ,#{username},#{sex},#{age})")
    void addUser(User user);

    void uptUser(User user);

    void delUser(int id);
}
