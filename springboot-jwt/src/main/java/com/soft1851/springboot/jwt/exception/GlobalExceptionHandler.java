package com.soft1851.springboot.jwt.exception;

import com.soft1851.springboot.jwt.common.Result;
import com.soft1851.springboot.jwt.common.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName GlobalExceptionHandler
 * @Description TODO
 * @Author mq_xu
 * @Date 2020/4/15
 * @Version 1.0
 */
@RestControllerAdvice(annotations = {RestController.class, Controller.class})
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 自定义异常的处理，统一在这里捕获返回JSON格式的友好提示
     *
     * @param exception
     * @return ResponseResult
     */
    @ExceptionHandler(value = {JwtException.class})
    @ResponseBody
    public Result sendError(JwtException exception) {
        log.error(exception.getMessage());
        return Result.failure(exception.getResultCode());
    }


    /**
     * NPE异常的处理
     *
     * @param exception
     * @return ResponseResult
     */
    @ExceptionHandler(value = {NullPointerException.class})
    @ResponseBody
    public Result sendError(NullPointerException exception) {
        log.error(exception.getMessage());
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }


    @ExceptionHandler(value = {ArithmeticException.class})
    @ResponseBody
    public Result sendErro(ArithmeticException exception) {
        return Result.failure(ResultCode.SPECIFIED_QUESTIONED_USER_NOT_EXIST);
    }

}