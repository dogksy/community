package com.zty.community.service;

import com.sun.xml.internal.ws.developer.Serialization;
import com.zty.community.modular.dto.GithubUserInfoDto;
import com.zty.community.modular.model.User;

/**
 * @author zty
 */
public interface LoginService extends Serialization {

    /**
     * 获取到的github用户信息持久化
     * 手动设置cookie
     * @param githubUserInfoDto
     *
     * @return
     */
    public User setCookie(GithubUserInfoDto githubUserInfoDto);
}
