package com.zty.community.service.impl;

import com.zty.community.modular.dao.QuestionMapper;
import com.zty.community.modular.dao.UserMapper;
import com.zty.community.modular.model.Question;
import com.zty.community.modular.model.User;
import com.zty.community.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author zty
 */
@Service
public class PublishServiceImpl implements PublishService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public String publicQuestion(Question question, HttpServletRequest request, Model model) {
        User user = null;
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        user = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                user = userMapper.findByToken(token);
                if (user != null) {
                    request.getSession().setAttribute("User", user);
                } else {
                    model.addAttribute("error", "用户未登录");
                    return "publish";
                }
                break;
            }
        }
        question.setCreateTime(new Date());
        question.setModifiedTime(question.getCreateTime());
        question.setCreator(user.getId());
        questionMapper.insert(question);
        return "redirect:hello";
    }
}
