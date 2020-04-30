package com.springbootlearning.notnullvertifcation;

import com.springbootlearning.notnullvertifcation.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.*;
import java.util.Set;

@SpringBootTest
class NotnullvertifcationApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 手动校验参数
     */
    @Test
    void checkManually(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator =factory.getValidator();
        Person person =Person.builder().id("123456").age(20)
                .email("soft1851@qq.com").sex("Man").phone("180942427962").name("soft1851").Region("sss").build();
        Set<ConstraintViolation<Person>>violations=validator.validate(person);
        for (ConstraintViolation<Person>constraintViolation:violations){
            System.out.println(constraintViolation.getMessage());
        }
    }

}
