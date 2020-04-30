package com.springbootlearning.notnullvertifcation.entity;

import com.springbootlearning.notnullvertifcation.annotation.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * @author wl
 * @ClassNamePerson
 * @Description 测试类
 * @Date 2020/4/30
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {
    @NotNull(message = "id不能为空")
    private String id;
    //    @Size(max = 30)
    @NotNull(message = "message不能为空")
    private String name;
    @Min(18)
    private Integer age;
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号格式错误")
    @NotBlank(message = "手机号不为空")
    private String phone;
    @NotNull(message =
            "email不能为空")
    @Email(message = "邮箱格式错误")
    private String email;
    @Pattern(regexp = "((^Man$|^Woman$|^UGM$))", message = "sex值在不可选范围")
    @NotNull(message = "sex不能为空")
    private String sex;

    @com.springbootlearning.notnullvertifcation.annotation.Region
    private String Region;
}
