package com.zty.community.controller;

import com.zty.community.dto.AccessTokenDto;
import com.zty.community.service.AuthorizaGitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizaController {

    @Autowired
    private AuthorizaGitService authorizaGitService;

    /**
     *Github 权限接口
     * @param code
     * @param state
     * @return
     */
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name = "state") String state) {

        System.out.println("进来了");
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id("5161ee6dfbf7ac02f804");
        accessTokenDto.setClient_secret("63e9fa18fbd8567d26ae8622aa47e0f01707e5e5");
        accessTokenDto.setRedirect_uri("http://localhost:8081/callback");
        authorizaGitService.getAccessTokenDto(accessTokenDto);
        return "hello";
    }
}
