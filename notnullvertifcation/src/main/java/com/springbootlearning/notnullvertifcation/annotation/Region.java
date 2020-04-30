package com.springbootlearning.notnullvertifcation.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RegionValidator.class)
@Documented
public @interface Region {

    String message() default "Region值不在可选范围内";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}


