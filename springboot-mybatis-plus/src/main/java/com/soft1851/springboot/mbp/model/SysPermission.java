package com.soft1851.springboot.mbp.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wl
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id",type = IdType.INPUT)
    private String id;

    private String parentId;

    private String type;

    private String icon;

    private String path;

    private String extension1;

    private String extension2;


}
