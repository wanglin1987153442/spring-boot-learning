package com.soft1851.spring.boot.aop.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author wl
 * @ClassNameAuthToken
 * @Description TODO
 * @Date 2020/4/13
 * @Version 1.0
 */
//运行时间
@Retention(RetentionPolicy.RUNTIME)
//切哪里
@Target({ElementType.METHOD,ElementType.TYPE})
//可被文档化
@Documented
public @interface AuthToken {
    /**
     * 访问接口所需要的身份 默认为空 则登录即可访问 可以定义多个
     * @return
     */
    String[] role_name()default "";

}
