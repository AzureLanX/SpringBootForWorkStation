package com.blue.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @BelongsProject: SpringBootForWorkStation
 * @BelongsPackage: com.blue.entity
 * @Author: JuferBlue
 * @CreateTime: 2025-01-05  13:19
 * @Description: TODO
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

        private static final long serialVersionUID = 1L;

        private Long id;

        //账号
        private String account;

        //昵称
        private String avatarUrl;

        //密码
        private String email;

        //邮箱
        private String password;

        //注册时间
        private LocalDateTime createTime;

        //登录时间
        private LocalDateTime lastLoginTime;

}
