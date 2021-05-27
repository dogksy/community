package com.zty.community.service;

import com.zty.community.modular.dto.AccessTokenDto;
import com.zty.community.modular.dto.GithubUserInfoDto;


public interface AuthorizaGitService {

     String getAccessTokenDto(AccessTokenDto accessTokenDto);

     GithubUserInfoDto getUser(String accessToken);
}
