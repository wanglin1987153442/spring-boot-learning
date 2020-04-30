package com.springbootlearning.notnullvertifcation.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

/**
 * @author wl
 * @ClassNameRegionValidator
 * @Description TODO
 * @Date 2020/4/30
 * @Version 1.0
 */

public class RegionValidator implements ConstraintValidator<Region,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        HashSet<Object>regios=new HashSet<>();
        regios.add("china");
        regios.add("china-taiwan");
        regios.add("china-hongkong");
        return regios.contains(s);
    }
}
