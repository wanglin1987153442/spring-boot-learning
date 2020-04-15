package com.soft1851.spring.boot.aop.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author wl
 * @ClassNameStudentInfo
 * @Description TODO
 * @Date 2020/1/16
 * @Version 1.0
 */
@Data
public class StudentInfo {
    private String num;
    private  String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long classId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  String classname;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  short sex;
}
