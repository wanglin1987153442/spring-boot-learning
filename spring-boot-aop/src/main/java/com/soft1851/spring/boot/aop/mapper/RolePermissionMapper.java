package com.soft1851.spring.boot.aop.mapper;


import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author
 * @Date 2020/4/13
 * @Version 1.0
 */
public interface RolePermissionMapper {

    /**
     * 根据角色id查询角色
     * @param id
     * @return
     */
    @Results({@Result(property = "permission", column = "permission_id", one=@One(select="com.soft1851.spring.boot.aop.mapper.SysPermissionMapper.getChildPermissionById")),
    })
    @Select("SELECT * FROM role_permission WHERE role_id=#{id}")
    List<Map<String, Object>> getRoleById(@Param("id") int id);
}
