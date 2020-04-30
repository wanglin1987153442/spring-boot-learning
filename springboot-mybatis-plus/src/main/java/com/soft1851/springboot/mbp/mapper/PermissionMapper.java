package com.soft1851.springboot.mbp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1851.springboot.mbp.model.SysPermission;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wl
 * @ClassNamePermissionMapper
 * @Description TODO
 * @Date 2020/4/16
 * @Version 1.0
 */
public interface PermissionMapper extends BaseMapper<SysPermission> {

List<SysPermission>selectqx(String user_id);
}
