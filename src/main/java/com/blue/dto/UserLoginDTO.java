package com.blue.dto;

import lombok.Data;

/**
 * @BelongsProject: SpringBootForWorkStation
 * @BelongsPackage: com.blue.dto
 * @Author: JuferBlue
 * @CreateTime: 2025-01-05  19:34
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class UserLoginDTO {
    private String account;
    private String password;
}
