package com.zty.community.service;

import com.zty.community.modular.dto.GithubUserInfoDto;
import com.zty.community.modular.model.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zty
 */
public interface LoginService  {

    /**
     * 获取到的github用户信息持久化
     * 手动设置cookie
     *
     * @param githubUserInfoDto
     * @return
     */
    User setCookie(GithubUserInfoDto githubUserInfoDto);

    /**
     * 二次登录token验证
     * @param request
     * @return
     */
    User loginVerify(HttpServletRequest request);
}
