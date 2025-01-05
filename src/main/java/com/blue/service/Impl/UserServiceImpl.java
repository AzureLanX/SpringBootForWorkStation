package com.blue.service.Impl;

import com.blue.dto.UserRegisterDTO;
import com.blue.entity.User;
import com.blue.mapper.UserMapper;
import com.blue.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     **/
    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        User user = new User();
        BeanUtils.copyProperties(userRegisterDTO, user);
        user.setCreateTime(LocalDateTime.now());

        //保存到数据库
        userMapper.insert(user);
    }

}
