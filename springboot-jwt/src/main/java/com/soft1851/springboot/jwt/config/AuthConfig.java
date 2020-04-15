package com.soft1851.springboot.jwt.config;

import com.soft1851.springboot.jwt.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author wl
 * @ClassNameqewe
 * @Description TODO
 * @Date 2020/1/14
 * @Version 1.0
 */





@Configuration
public class AuthConfig implements WebMvcConfigurer {

@Resource
private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addpathpattern需要拦截
        registry.addInterceptor(authInterceptor).addPathPatterns("/api/**").excludePathPatterns("/api/login");
    }

}
