package com.zty.community.service;

import com.zty.community.dto.AccessTokenDto;
import com.zty.community.dto.GithubUserInfo;
import org.springframework.stereotype.Service;


public interface AuthorizaGitService {

    public String getAccessTokenDto(AccessTokenDto accessTokenDto);

    public GithubUserInfo getUser(String accessToken);
}
