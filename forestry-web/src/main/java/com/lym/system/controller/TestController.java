package com.lym.system.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "测试Controller")
public class TestController {

    @GetMapping("hello")
    public String he(){
        return "hello";
    }

    @GetMapping("/employee/basic/hello")
    public String hello(){
        return "/employee/basic/hello";
    }

    @GetMapping("/employee/advanced/hello")
    public String hello2(){
        return "/employee/advanced/hello";
    }
}
