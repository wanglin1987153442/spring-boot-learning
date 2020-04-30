package com.springbootlearning.oauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wl
 * @ClassNameTestController
 * @Description TODO
 * @Date 2020/4/29
 * @Version 1.0
 */
@RestController
public class TestController {
    @RequestMapping()
    public String simpleIndex() {
        return "index";
    }
}
