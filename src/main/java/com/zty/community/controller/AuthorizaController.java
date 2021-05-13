package com.zty.community.controller;

import com.zty.community.modular.dao.UserMapper;
import com.zty.community.modular.dto.AccessTokenDto;
import com.zty.community.modular.dto.GithubUserInfoDto;
import com.zty.community.modular.model.User;
import com.zty.community.service.AuthorizaGitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@EnableConfigurationProperties
@Controller
public class AuthorizaController {

    @Autowired
    private AuthorizaGitService authorizaGitService;

    @Autowired
    private AccessTokenDto accessTokenDto;

    @Autowired
    private UserMapper userMapper;

    /**
     * Github 权限接口
     * @param code
     * @param state
     * @param request
     * @return
     */
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request) {
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        String accessToken = authorizaGitService.getAccessTokenDto(accessTokenDto);
        GithubUserInfoDto githubUser = authorizaGitService.getUser(accessToken);
        if (githubUser != null) {
            //去做登录成功操作
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.addUserInfo(user);
            request.getSession().setAttribute("User", githubUser);
            return "redirect:hello";
        } else {
            //去做登录失败操作
            return "redirect:hello";
        }
    }
}
