package com.foxbill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.foxbill.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
