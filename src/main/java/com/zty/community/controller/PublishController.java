package com.zty.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 周天扬
 * @date 2021/06/04
 */
@Controller
public class PublishController {
    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/formInfo")
    public String formInfo(@RequestParam String InitiateQuestions ){
        InitiateQuestions = InitiateQuestions+"进入了controller";
        System.out.println(InitiateQuestions);
        return InitiateQuestions;
    }
}
