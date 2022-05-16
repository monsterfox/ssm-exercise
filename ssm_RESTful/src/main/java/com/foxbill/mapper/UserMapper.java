package com.foxbill.mapper;

import com.foxbill.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    @Select("select * from t_user")
    List<User> findAllUser();

    @Select("select * from t_user where id = #{id}")
    User findUserById(Integer id);

    @Insert("insert into t_user values(null ,#{username},#{sex},#{age})")
    void addUser(User user);

    @Update("update t_user set username = #{username},sex = #{sex},age = #{age} where id = #{id}")
    void uptUser(User user);

    @Delete("delete from t_user where id = #{id}")
    void delUser(int id);
}
