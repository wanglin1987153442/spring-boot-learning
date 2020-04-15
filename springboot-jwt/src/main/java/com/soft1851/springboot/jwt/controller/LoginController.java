package com.soft1851.springboot.jwt.controller;

import com.soft1851.springboot.jwt.common.Result;
import com.soft1851.springboot.jwt.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author wl
 * @ClassNamelogin
 * @Description TODO
 * @Date 2020/4/15
 * @Version 1.0
 */
@RestController
@RequestMapping("/api")
public class LoginController {
    @Resource
    private UserService userService;
    @PostMapping("/login")
    public Result login(String num ,String passowrd,String role){
        return userService.login(num,passowrd,role);
    }

    @PutMapping("/thing")
    public Result dothing(){
        return userService.dothing();
    }
}
