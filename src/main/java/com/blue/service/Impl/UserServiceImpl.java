package com.blue.service.Impl;

import com.blue.constant.EmailConstant;
import com.blue.constant.MessageConstant;
import com.blue.dto.UserLoginDTO;
import com.blue.dto.UserRegisterDTO;
import com.blue.entity.User;
import com.blue.exception.AccountNotFoundException;
import com.blue.exception.PasswordErrorException;
import com.blue.exception.VerificationCodeErrorException;
import com.blue.mapper.UserMapper;
import com.blue.service.UserService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@CommonsLog
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     **/
    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        //获取邮箱和验证码
        String email = userRegisterDTO.getEmail();
        String verificationCode = userRegisterDTO.getVerificationCode();
        //从redis中获取验证码
        String code = (String) redisTemplate.opsForValue().get(email);
        //判断验证码是否正确
        if(!verificationCode.equals(code)){
            //验证码错误
            throw new VerificationCodeErrorException(EmailConstant.EMAIL_VERIFICATION_CODE_ERROR);
        }
        //登录成功后删除redis中的验证码
        redisTemplate.delete(email);
        //将dto转换为实体对象
        User user = new User();
        BeanUtils.copyProperties(userRegisterDTO, user);
        user.setCreateTime(LocalDateTime.now());

        //保存到数据库
        userMapper.insert(user);
    }

    /**
     * 用户登录
     **/
    @Override
    public User login(UserLoginDTO userLoginDTO) {
        log.info("用户登录：{}");
        String account = userLoginDTO.getAccount();
        String password = userLoginDTO.getPassword();
        //1.根据用户名查询数据库中的数据
        User user = userMapper.getByAccount(userLoginDTO.getAccount());
        //2.处理各种异常情况（用户名不存在、密码不对）
        if(user == null){
            //账号不存在
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_FOUND);
        }
        if(!password.equals(user.getPassword())){
            //密码错误
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }
        //3.返回实体对象
        log.info("用户登录成功：{}");
        return user;

    }

}
