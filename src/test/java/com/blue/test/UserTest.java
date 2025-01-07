package com.blue.test;

import com.blue.controller.UserController;
import com.blue.entity.User;
import com.blue.result.Result;
import com.blue.service.UserService;
import com.blue.vo.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @BelongsProject: SpringBootForWorkStation
 * @BelongsPackage: com.blue.test
 * @Author: JuferBlue
 * @CreateTime: 2025-01-07  09:42
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class UserTest {
    @Autowired
    private UserController userController;

    /**
     * 根据用户id查询用户信息
     **/
    @Test
    public void getUserByIdTest(){
        Result<UserVO> userVO = userController.getUserById(19L);
        System.out.println(userVO.getData().getAccount());

    }
}
