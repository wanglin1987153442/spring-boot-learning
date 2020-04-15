package com.soft1851.spring.boot.aop.service;

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
class RolePermissionServiceTest {
    @Resource
    private RolePermissionService service;

    @Test
    void getRolePermissionByAdmin() {
        System.out.println(service.getAdminRolePermission());;
    }

    @Test
    void getRolePermissionBySysAdmin() {
    }
}