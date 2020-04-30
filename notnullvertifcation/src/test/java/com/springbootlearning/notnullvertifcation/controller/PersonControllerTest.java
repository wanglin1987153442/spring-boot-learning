package com.springbootlearning.notnullvertifcation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootlearning.notnullvertifcation.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {
@Autowired
private MockMvc mockMvc;
@Autowired
private ObjectMapper objectMapper;
    @Test
    void savePerson()throws Exception {
        Person person =Person.builder().id("123456").age(20)
                .email("soft1851@qq.com").sex("Man").phone("18094247962").name("soft1851").build();
        MockHttpServletRequestBuilder requestBuilder= MockMvcRequestBuilders.post("/api/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(person));
        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getPersonById() throws Exception {
        //路径参数不设置内容 类型选择text/plain
        MockHttpServletRequestBuilder requestBuilder =MockMvcRequestBuilders.get("/api/person/1122")
                .contentType(MediaType.TEXT_PLAIN);
        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string("getPersonById.id:id不能小于六位"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
        ;
    }

    @Test
    void getPersonByName() throws Exception {
        MockHttpServletRequestBuilder requestBuilder =MockMvcRequestBuilders.get("/api/person")
                .contentType(MediaType.APPLICATION_JSON).param("name","soft18511861");
        mockMvc.perform(requestBuilder)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string("getPersonByName:name长度超出范围"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        ;
    }
}