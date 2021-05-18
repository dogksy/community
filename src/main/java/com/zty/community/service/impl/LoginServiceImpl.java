package com.zty.community.service.impl;

import com.zty.community.modular.dao.UserMapper;
import com.zty.community.modular.dto.GithubUserInfoDto;
import com.zty.community.modular.model.User;
import com.zty.community.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.UUID;

/**
 * @author zty
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User setCookie(GithubUserInfoDto githubUser) {
        //去做登录成功操作
        User user = new User();
        user.setToken(UUID.randomUUID().toString());
        user.setName(githubUser.getName());
        user.setAccountId(String.valueOf(githubUser.getId()));
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());
        userMapper.insert(user);
        return user;
    }

    @Override
    public String encoding() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
