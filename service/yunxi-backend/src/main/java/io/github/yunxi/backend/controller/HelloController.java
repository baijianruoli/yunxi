package io.github.yunxi.backend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("hello")
public class HelloController {




    @RequestMapping("/hello")
    public String hello(String name)
    {
        return name;
    }

}
