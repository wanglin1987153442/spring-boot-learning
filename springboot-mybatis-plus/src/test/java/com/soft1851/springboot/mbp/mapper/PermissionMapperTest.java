package com.soft1851.springboot.mbp.mapper;

import com.soft1851.springboot.mbp.model.SysPermission;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class PermissionMapperTest {
    @Resource
    private PermissionMapper sysPermissionMapper;

    @Test
    void selectAll() {
        List<SysPermission> sysPermissions = sysPermissionMapper.selectList(null);
        sysPermissions.forEach(System.out::println);
    }

    @Test
    void insert() {
        SysPermission sysPermission = SysPermission.builder().id("878").icon("1").parentId("1").path("1").type("121").extension1("1").extension2("2").build();
        sysPermissionMapper.insert(sysPermission);

    }

    @Test
    void delect() {
        sysPermissionMapper.deleteById(5);

    }

    @Test
    void update() {
        SysPermission sysPermission = SysPermission.builder().id("878").extension2("nihao").build();
        sysPermissionMapper.updateById(sysPermission);
    }

    @Test
    void batchupdate() {
        List<String> list = new ArrayList<>();
        list.add("88");
        list.add("2");
        sysPermissionMapper.deleteBatchIds(list);
    }


    @Test
    void selectqx() {
        List<SysPermission> selectqx = sysPermissionMapper.selectqx("2");
        selectqx.forEach(System.out::println);
    }
}