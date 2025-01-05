package com.blue.test;

import com.blue.dto.UserRegisterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DTOTest {
    @Test
    public void testDTO(){
        System.out.println("测试DTO");
        UserRegisterDTO userRegisterDTO = new UserRegisterDTO();
        userRegisterDTO.setAccount("123");
        System.out.println(userRegisterDTO.getAccount());
    }
}
