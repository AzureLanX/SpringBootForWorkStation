package com.blue.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: SpringBootForWorkStation
 * @BelongsPackage: com.blue.controller
 * @Author: JuferBlue
 * @CreateTime: 2025-01-05  11:28
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
public class UserController {
    @GetMapping("/user")
    public String getUser(){
        return "hello world nihao";
    }
}
