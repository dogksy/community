package com.zty.community.controller;

import com.zty.community.modular.dao.UserMapper;
import com.zty.community.modular.dto.AccessTokenDto;
import com.zty.community.modular.dto.GithubUserInfoDto;
import com.zty.community.modular.model.User;
import com.zty.community.service.AuthorizaGitService;
import com.zty.community.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@EnableConfigurationProperties
@Controller
public class AuthorizaController {

    @Autowired
    private AuthorizaGitService authorizaGitService;

    @Autowired
    private AccessTokenDto accessTokenDto;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LoginService loginService;

    /**
     * Github 权限接口
     *
     * @param code
     * @param state
     * @return
     */
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletResponse response,
                           HttpServletRequest request) {
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        String accessToken = authorizaGitService.getAccessTokenDto(accessTokenDto);
        GithubUserInfoDto githubUser = authorizaGitService.getUser(accessToken);
        if (githubUser != null) {
//            去做登录成功操作
            User user = loginService.setCookie(githubUser);
            //设置cookie 和session
            request.getSession().setAttribute("User", githubUser);
            response.addCookie(new Cookie("token", user.getToken()));
            return "redirect:hello";
        } else {
            //去做登录失败操作
            return "redirect:hello";
        }
    }
}
