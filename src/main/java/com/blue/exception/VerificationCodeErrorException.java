package com.blue.exception;

/**
 * @BelongsProject: SpringBootForWorkStation
 * @BelongsPackage: com.blue.exception
 * @Author: JuferBlue
 * @CreateTime: 2025-01-06  22:45
 * @Description: TODO
 * @Version: 1.0
 */
public class VerificationCodeErrorException extends BaseException{

        public VerificationCodeErrorException() {
        }

        public VerificationCodeErrorException(String msg) {
            super(msg);
        }
}
