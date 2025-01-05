package com.blue.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: SpringBootForWorkStation
 * @BelongsPackage: com.blue.properties
 * @Author: JuferBlue
 * @CreateTime: 2025-01-05  20:35
 * @Description: TODO
 * @Version: 1.0
 */
@Component
@ConfigurationProperties(prefix = "blue.jwt")
@Data
public class JwtProperties {
        private String userSecretKey;
        private long userTtl;
        private String userTokenName;
}
