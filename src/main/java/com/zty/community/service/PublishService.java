package com.zty.community.service;

import com.zty.community.modular.model.Question;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zty
 */
public interface PublishService {
    /**
     * 发布问题
     *
     * @param question
     * @param request
     * @param model
     * @return
     */
    String publicQuestion(Question question, HttpServletRequest request, Model model);
}
