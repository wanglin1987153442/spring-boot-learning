package com.soft1851.spring.boot.aop.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2020-04-13 19:51:04
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = 361672736702572732L;
    /**
    * 用户id
    */
    private Integer userId;
    /**
    * 用户昵称
    */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
    * 头像
    */
    private String avatar;
    /**
    * 真实姓名
    */
    private String realName;
    /**
    * 创建时间
    */
    private Date createTime;
}