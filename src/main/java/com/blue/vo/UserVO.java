package com.blue.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @BelongsProject: SpringBootForWorkStation
 * @BelongsPackage: com.blue.vo
 * @Author: JuferBlue
 * @CreateTime: 2025-01-07  09:34
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@Builder
public class UserVO {
    private Long id;
    private String account;
    private String avatarUrl;
    private String email;
}
