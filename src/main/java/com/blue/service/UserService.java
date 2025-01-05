package com.blue.service;

import com.blue.dto.UserRegisterDTO;

public interface UserService {

    /**
     * 用户注册
     **/
    void register(UserRegisterDTO userRegisterDTO);

}
