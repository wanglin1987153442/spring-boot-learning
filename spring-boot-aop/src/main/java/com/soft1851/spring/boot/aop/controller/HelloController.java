package com.soft1851.spring.boot.aop.controller;


import com.soft1851.spring.boot.aop.annotation.ControllerWebLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wl
 * @ClassNameHelloController
 * @Description TODO
 * @Date 2020/4/12
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/api/")
@Slf4j
public class HelloController {

    @RequestMapping(value = "hello")
    @ControllerWebLog(name = "getHello",isSaved = true)
    public String getHello(String arg1,int arg2){
        log.info("控制层参数"+arg1);
        log.info("控制层参数"+arg2);
        //休眠获取接口耗时

        RequestAttributes at = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) at;
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        System.out.println(
                request.getHeader("user-agent"));
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return  "hello spring boot";
    }
}
