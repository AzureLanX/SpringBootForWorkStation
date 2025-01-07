package com.blue.service;

import com.blue.dto.UserLoginDTO;
import com.blue.dto.UserRegisterDTO;
import com.blue.entity.User;

public interface UserService {

    /**
     * 用户注册
     **/
    void register(UserRegisterDTO userRegisterDTO);

    /**
     * 用户登录
     **/
    User login(UserLoginDTO userLoginDTO);

    /**
     * 根据用户id查询用户信息
     **/
    User getUserById(Long userId);
}
