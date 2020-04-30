package com.springbootlearning.notnullvertifcation.service;

import com.springbootlearning.notnullvertifcation.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.annotation.Resource;
import javax.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonServiceTest {
@Resource
private PersonService personService;
    @Test
    @ExceptionHandler(ConstraintViolationException.class)
    void validatePerson() {
        Person person =Person.builder().id("123456").age(20)
                .email("soft1851@qq.com").sex("Man").phone("180942247962").name("soft1851").build();
        personService.validatePerson(person);
    }


}