package com.soft1851.spring.boot.aop.aspect;


import com.soft1851.spring.boot.aop.annotation.AuthToken;
import com.soft1851.spring.boot.aop.common.Result;
import com.soft1851.spring.boot.aop.common.ResultCode;
import com.soft1851.spring.boot.aop.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/13
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class AuthTokenAspect {
    @Resource
    private SysUserMapper mapper;

    private ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    /**
     * 配置加上自定义注解的方法为切点
     * @param authToken
     */
    @Pointcut("@annotation(authToken)")
    public void doAuthToken(AuthToken authToken) {
    }



//    @Before(value = "webLog()")
//    public void doBefore(JoinPoint joinPoint){
//        //接收请求，获得请求的request对象
//        RequestAttributes at = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes sra = (ServletRequestAttributes) at;
//        //以下通过连接点和注解获取相关信息
//        assert sra != null;
//        HttpServletRequest request = sra.getRequest();
//        log.info("token:" + request.getHeader("token"));
//        log.info("请求URI:" + request.getRequestURI());
//        log.info("请求URL:" + request.getRequestURL());
//        log.info("请求头的User-Agent:" + request.getHeader("User-Agent"));
//        log.info("请求方法:" + request.getMethod());
//        log.info("请求地址:" + request.getRemoteAddr());
//        log.info("连接点对象通过反射获得类名和方法名" + joinPoint.getSignature().getDeclaringTypeName() + "."
//                + joinPoint.getSignature().getName());
//        log.info("AOP拦截获得参数:" + Arrays.toString(joinPoint.getArgs()));
//        // 定义一个map用来记录日志信息，并将其put入threadLocal
//        Map<String, Object> map = new HashMap<>(16);
//        map.put("uri", request.getRequestURI());
//        map.put("url", request.getRequestURL());
//        map.put("user-agent", request.getHeader("User-Agent"));
//        map.put("request-method", request.getMethod());
//        map.put("remote-address", request.getRemoteAddr());
//        map.put("class-method", joinPoint.getSignature().getDeclaringTypeName() +  "."
//                + joinPoint.getSignature().getName());
//        map.put("arguments", Arrays.toString(joinPoint.getArgs()));
//        threadLocal.set(map);
//    }
//
//    @AfterReturning(value = "webLog() && @annotation(authToken)", returning = "ret")
//    public void doAfterReturning(AuthToken authToken, Object ret) throws Throwable {
//        //从当前线程变量取出数据
//        Map<String, Object> threadInfo = threadLocal.get();
//        //将请求的目标方法getHello()的执行的返回结果存入对象
//        threadInfo.put("result", ret);
//        // 处理完成请求，返回内容
//        log.info("RESPONSE : " + ret);
//    }


    /**
     * object是指controller方法返回的类型
     */
    @Around(value = "doAuthToken(authToken)", argNames = "pjp,authToken")
    public Object doAround(ProceedingJoinPoint pjp, AuthToken authToken) throws Throwable{
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        // 取得注解中的role_name的值
        String[] roleNames = authToken.role_name();
        //没有role的值
        if (roleNames.length <= 1) {
            // 只需认证
            String token = request.getHeader("token");
            String id = request.getParameter("id");
            Map<String, Object> map = mapper.getUserById(id);
            // 如果id为空， 证明用户没有登录
            if (token != null && roleNames[0].equals(map.get("role_name"))) {
                // 返回controller方法的值
                return pjp.proceed();
            }
            return Result.success(ResultCode.PERMISSION_NO_ACCESS);
        }else {
            // 请求头中取出role，验证身份
            String id = request.getParameter("id");
            Map<String, Object> map = mapper.getUserById(id);
            for (String roleName : roleNames) {
                if (roleName.equals(map.get("role_name"))) {
                    // 身份匹配成功
                    return pjp.proceed();
                }
            }
            return Result.success(ResultCode.PERMISSION_NO_ACCESS);
        }

    }
}
