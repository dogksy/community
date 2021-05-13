package com.zty.community.service;

import com.zty.community.modular.dto.AccessTokenDto;
import com.zty.community.modular.dto.GithubUserInfoDto;


public interface AuthorizaGitService {

    public String getAccessTokenDto(AccessTokenDto accessTokenDto);

    public GithubUserInfoDto getUser(String accessToken);
}
