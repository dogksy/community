package com.zty.community.controller;

import com.zty.community.modular.model.User;
import com.zty.community.service.LoginService;
import com.zty.community.utils.ObjCheck;
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
        User user = loginService.loginVerify(request);
        if (ObjCheck.objCheckNull(user)) {
            return "hello";
        } else {
            return "publish";
        }
    }
}
