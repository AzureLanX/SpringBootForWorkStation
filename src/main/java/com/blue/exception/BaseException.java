package com.blue.exception;

/**
 * @BelongsProject: SpringBootForWorkStation
 * @BelongsPackage: com.blue.exception
 * @Author: JuferBlue
 * @CreateTime: 2025-01-05  18:36
 * @Description: TODO
 * @Version: 1.0
 */
public class BaseException extends RuntimeException{

        public BaseException() {
        }

        public BaseException(String msg) {
            super(msg);
        }
}
