package com.soft1851.spring.boot.aop.mapper;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/13
 * @Version 1.0
 */
@SpringBootTest
class RolePermissionMapperTest {
    @Resource
    private RolePermissionMapper mapper;

    @Test
    void getRoleById() {
        System.out.println(mapper.getRoleById(1));
    }
}