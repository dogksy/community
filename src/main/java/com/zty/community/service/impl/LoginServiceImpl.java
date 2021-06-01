package com.zty.community.service.impl;

import com.zty.community.modular.dao.UserMapper;
import com.zty.community.modular.dto.GithubUserInfoDto;
import com.zty.community.modular.model.User;
import com.zty.community.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @author zty
 */
@Service
public class LoginServiceImpl implements LoginService, Serializable {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User setCookie(GithubUserInfoDto githubUser) {
        //去做登录成功操作
        User user = new User();
        user.setToken(UUID.randomUUID().toString());
        user.setName(githubUser.getName());
        user.setAccountId(String.valueOf(githubUser.getId()));
        user.setGmtCreate(new Date());
        user.setGmtModified(user.getGmtCreate());
        user.setBio(githubUser.getBio());
        userMapper.insert(user);
        return user;
    }

    @Override
    public User loginVerify(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies==null){
            return null;
        }
        User user = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                user = userMapper.findByToken(token);
                if (user != null) {
                    request.getSession().setAttribute("User", user);
                }
                break;
            }
        }
        return user;
    }
}
