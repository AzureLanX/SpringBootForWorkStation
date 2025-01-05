package com.blue.mapper;

import com.blue.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    /**
     * 用户注册
     **/
    @Insert("insert into users (account, email, password, create_time) " +
            "VALUES (#{account}, #{email}, #{password}, #{createTime})")
    void insert(User user);
}
