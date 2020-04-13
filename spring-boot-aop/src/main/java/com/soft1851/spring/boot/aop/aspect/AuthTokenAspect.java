package com.soft1851.spring.boot.aop.aspect;

import com.soft1851.spring.boot.aop.annotation.AuthToken;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wl
 * @ClassNameAuthTokenAspect
 * @Description TODO
 * @Date 2020/4/13
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class AuthTokenAspect {
    /**
     * 配置加上自定义注解的为切点
     *
     * @param authToken
     */
    @Pointcut("@annotation(authToken)")
    public void doAuthToken(AuthToken authToken) {

    }

    @Around(value = "doAuthToken(authToken)", argNames = "pjp,authToken")
    public Object doAround(ProceedingJoinPoint pjp, AuthToken authToken) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        //获取请求头
        String[] roleNames = authToken.role_name();
        System.out.println(roleNames.length);
        if (roleNames.length <= 1) {
            //只需要认证
            String id = request.getHeader("id");
            System.out.println(id);
            //id 为空 证明用户没登录
            if (id != null) {
                return pjp.proceed();
            }
            return "请先登录";
        } else {
            String role = request.getHeader("role");
            log.info(role);
            for (String rolename : roleNames) {
                if (rolename.equals(role)) {
                    //身份匹配成功 调用目标方法
                    return pjp.proceed();
                }
            }
            return "权限不足";
        }
    }

}
