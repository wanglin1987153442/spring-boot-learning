package com.soft1851.spring.boot.aop.service.serviceimpl;


import com.soft1851.spring.boot.aop.mapper.RolePermissionMapper;
import com.soft1851.spring.boot.aop.mapper.SysPermissionMapper;
import com.soft1851.spring.boot.aop.service.RolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/4/13
 * @Version 1.0
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Resource
    private RolePermissionMapper mapper;
    @Resource
    private SysPermissionMapper permissionMapper;

    @Override
    public List<Map<String, Object>> getAdminRolePermission() {
        return permissionMapper.getParentPermission();
    }

    @Override
    public List<Map<String, Object>> getRolePermissionBySysAdmin(int sysAdminId) {
        return mapper.getRoleById(sysAdminId);
    }
}
