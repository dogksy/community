package com.zty.community.controller;

import com.zty.community.modular.model.Question;
import com.zty.community.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

/**
 * @author 周天扬
 * @date 2021/06/04
 */
@Controller
public class PublishController implements Serializable {

    @Autowired
    private PublishService publishService;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @PostMapping("/formInfo")
    public String formInfo(@RequestBody() Question question,
            HttpServletRequest request,
            Model model) {
        return publishService.publicQuestion(question, request, model);
    }
}
