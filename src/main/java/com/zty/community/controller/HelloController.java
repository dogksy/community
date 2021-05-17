package com.zty.community.controller;

import com.zty.community.modular.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
