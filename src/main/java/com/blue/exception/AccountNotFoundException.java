package com.blue.exception;

/**
 * @BelongsProject: SpringBootForWorkStation
 * @BelongsPackage: com.blue.exception
 * @Author: JuferBlue
 * @CreateTime: 2025-01-05  19:58
 * @Description: TODO
 * @Version: 1.0
 */

public class AccountNotFoundException extends BaseException {

    public AccountNotFoundException() {
    }
    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
