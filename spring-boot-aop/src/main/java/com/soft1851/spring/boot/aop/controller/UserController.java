package com.soft1851.spring.boot.aop.controller;

import com.soft1851.spring.boot.aop.annotation.AuthToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wl
 * @ClassNameUserController
 * @Description TODO
 * @Date 2020/4/13
 * @Version 1.0
 */
@RestController
@Slf4j
public class UserController {
    /**
     * 无需任何校验不用加注解
     *
     * @param name
     * @return
     */
    @GetMapping("hello")
    public String hello(String name) {
        log.info("hello()方法无需鉴权无需认证,当前用户名" + name);
        return "hello方法访问成功";
    }

    /**
     * 需要登录认证
     *
     * @param name
     * @return
     */
    @GetMapping("user")
    @AuthToken
    public String user(String name) {
        log.info("user()方法需要认证，当前用户名"+name);
        return "user()方法访问成功";
    }

    /**
     * 需要鉴权
     * @param name
     * @return
     */
    @GetMapping("admin")
    @AuthToken(role_name = {"admin","superAdmin"})
    public String admin(String name){
        log.info("admin()方法需要鉴权,当前用户名"+name);
        return "admin()方法访问成功";
    }


}
