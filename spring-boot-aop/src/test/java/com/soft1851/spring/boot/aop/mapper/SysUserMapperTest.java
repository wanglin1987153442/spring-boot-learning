package com.soft1851.spring.boot.aop.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/13
 * @Version 1.0
 */
@SpringBootTest
class SysUserMapperTest {
    @Resource
    private SysUserMapper mapper;

    @Test
    void getUserById() {
        System.out.println(mapper.getUserById("2"));
    }
}