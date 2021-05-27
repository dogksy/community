package com.zty.community.controller;

import com.zty.community.service.LoginService;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        loginService.loginVerify(request);
        Flyway flyway = Flyway.configure().dataSource("","","").load();
        flyway.migrate();
        return "hello";
    }
}
