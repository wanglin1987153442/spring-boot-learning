package com.soft1851.springboot.jwt.service;

import com.soft1851.springboot.jwt.common.Result;

/**
 * @author wl
 * @ClassNameuserService
 * @Description TODO
 * @Date 2020/4/15
 * @Version 1.0
 */
public interface UserService {
    /**
     * 登陆
     * @param num
     * @param password
     * @return
     */
    Result login(String num,String password,String role);

    /**
     * 做某事
     * @return
     */
    Result dothing();
}
