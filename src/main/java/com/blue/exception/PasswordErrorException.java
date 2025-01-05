package com.blue.exception;

/**
 * @BelongsProject: SpringBootForWorkStation
 * @BelongsPackage: com.blue.exception
 * @Author: JuferBlue
 * @CreateTime: 2025-01-05  20:00
 * @Description: TODO
 * @Version: 1.0
 */
public class PasswordErrorException extends BaseException {

    public PasswordErrorException() {
    }

    public PasswordErrorException(String msg) {
        super(msg);
    }
}
