package com.blue.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @BelongsProject: SpringBootForWorkStation
 * @BelongsPackage: com.blue.vo
 * @Author: JuferBlue
 * @CreateTime: 2025-01-05  19:44
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginVO implements Serializable {
    private Long id;
    private String account;
    private String email;
    private String token;
}
