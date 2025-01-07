package com.blue.controller;

import com.blue.constant.EmailConstant;
import com.blue.constant.JwtClaimsConstant;
import com.blue.dto.UserLoginDTO;
import com.blue.dto.UserRegisterDTO;
import com.blue.entity.User;
import com.blue.properties.JwtProperties;
import com.blue.result.Result;
import com.blue.service.UserService;
import com.blue.utils.JwtUtil;
import com.blue.utils.SendEmailUtil;
import com.blue.vo.UserLoginVO;
import com.blue.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private SendEmailUtil sendEmailUtil;
    /**
     * 请求发送验证码
     **/
    @GetMapping("/getRegisterVerificationCode")
    public Result getRegisterVerificationCode(@RequestParam String email) {
        log.info("请求发送验证码：{}", email);
        //发送验证码
        String code = sendEmailUtil.sendEmail(email);
        //将验证码存入redis,有效时间为五分钟
        redisTemplate.opsForValue().set(email, code, EmailConstant.EMAIL_VERIFICATION_CODE_TIME, TimeUnit.MINUTES);
        return Result.success();
    }
    /**
     * 用户注册
     **/
    @PostMapping("/register")
    public Result register(@RequestBody UserRegisterDTO userRegisterDTO) {
        log.info("用户注册：{}", userRegisterDTO);
        userService.register(userRegisterDTO);

        return Result.success();
    }

    /**
     * 用户登录
     **/
    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登录：{}", userLoginDTO);
        //用户登录
        User user = userService.login(userLoginDTO);
        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());
        String token = JwtUtil.createJWT(jwtProperties.getUserSecretKey(), jwtProperties.getUserTtl(), claims);
        //组装返回的数据
        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(user.getId())
                .account(user.getAccount())
                .token(token)
                .build();
        //返回
        return Result.success(userLoginVO);
    }
    /**
     * 根据用户id查询用户信息
     **/
    @GetMapping("/getUserById")
    public Result<UserVO> getUserById(@RequestParam Long id) {
        log.info("根据用户id查询用户信息：{}", id);
        User user = userService.getUserById(id);
        //组装数据
        UserVO userVO = UserVO.builder()
                .id(user.getId())
                .account(user.getAccount())
                .avatarUrl(user.getAvatarUrl())
                .email(user.getEmail())
                .build();
        return Result.success(userVO);
    }

}
