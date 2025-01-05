package com.blue.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @BelongsProject: SpringBootForWorkStation
 * @BelongsPackage: com.blue.test
 * @Author: JuferBlue
 * @CreateTime: 2025-01-05  19:26
 * @Description: TODO
 * @Version: 1.0
 */
@SpringBootTest
public class EmailValidationTest {

    @Test
    public void testEmailValidation(){
        String email = "lyh2846823009@163.com";
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[a-zA-Z]{2,}$";
        System.out.println(email.matches(regex)); // 输出 true 或 false
    }
}
