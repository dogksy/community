package com.zty.community.controller;

import com.zty.community.dto.AccessTokenDto;
import com.zty.community.dto.GithubUserInfo;
import com.zty.community.service.AuthorizaGitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@EnableConfigurationProperties
@Controller
public class AuthorizaController {

    @Autowired
    private AuthorizaGitService authorizaGitService;

    @Autowired
    private AccessTokenDto accessTokenDto;

    /**
     *Github 权限接口
     * @param code
     * @param state
     * @return
     */
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name = "state") String state) {
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        String accessToken = authorizaGitService.getAccessTokenDto(accessTokenDto);
        GithubUserInfo user = authorizaGitService.getUser(accessToken);
        return "hello";
    }
}
