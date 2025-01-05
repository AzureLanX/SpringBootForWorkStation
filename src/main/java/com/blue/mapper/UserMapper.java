package com.blue.mapper;

import com.blue.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * 用户注册
     **/
    @Insert("insert into users (account, email, password, create_time) " +
            "VALUES (#{account}, #{email}, #{password}, #{createTime})")
    void insert(User user);

    /**
     * 用户登录
     **/
    @Select("select * from users where account = #{account}")
    User getByAccount(String account);
}
