package com.blue.handler;

import com.blue.constant.MessageConstant;
import com.blue.exception.BaseException;
import com.blue.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局异常处理器，处理项目中抛出的业务异常
 */

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 捕获业务异常
     **/
    @ExceptionHandler
    public Result exceptionHandler(BaseException ex) {
        log.error("异常信息：{}", ex.getMessage());
        return Result.error(ex.getMessage());
    }

    /**
     * 捕获sql异常
     **/
    @ExceptionHandler
    public Result exceptionHandler(SQLIntegrityConstraintViolationException ex) {
        String message = ex.getMessage();
        if (message.contains("Duplicate entry")) {
            // Duplicate entry 'admin' for key 'idx_username'
            String[] split = message.split(" ");
            String name = split[2];
            //去掉单引号
            name = name.substring(1, name.length() - 1);
            //判断是账号重复还是邮箱重复
            if (name.matches("^[\\w-\\.]+@([\\w-]+\\.)+[a-zA-Z]{2,}$")) {
                String msg = name + MessageConstant.ALREADY_BIND;
                return Result.error(msg);
            } else {
                String msg = name + MessageConstant.ALREADY_EXIST;
                return Result.error(msg);
            }

        } else {
            return Result.error(MessageConstant.UNKNOWN_ERROR);
        }
    }
}
