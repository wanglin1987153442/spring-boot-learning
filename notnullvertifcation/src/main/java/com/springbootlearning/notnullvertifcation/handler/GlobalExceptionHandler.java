package com.springbootlearning.notnullvertifcation.handler;

import com.springbootlearning.notnullvertifcation.controller.PersonController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wl
 * @ClassNameGlobalExceptionHandler
 * @Description TODO
 * @Date 2020/4/30
 * @Version 1.0
 */
@ControllerAdvice(assignableTypes = {PersonController.class})
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>>hanleValidationExceptions(MethodArgumentNotValidException ex){
        Map<String,String>errors =new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String filedName=((FieldError)error).getField();
            String erroMessage=error.getDefaultMessage();
            errors.put(filedName,erroMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }



    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<String>handleConstraintViolationException(ConstraintViolationException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
