package com.soft1851.spring.boot.aop.annotation;

/**
 * @author wl
 * @ClassNamesdsa
 * @Description TODO
 * @Date 2020/4/13
 * @Version 1.0
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 验证token
 * @author 林小派
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface VerifyToken {
    boolean required() default true;
}
