package com.zty.community.service.impl;

import com.alibaba.fastjson.JSON;
import com.zty.community.modular.dto.AccessTokenDto;
import com.zty.community.modular.dto.GithubUserInfoDto;
import com.zty.community.service.AuthorizaGitService;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author zty
 * @date 2021/05/08
 */
@Service
public class AuthorizaGitServiceImpl implements AuthorizaGitService {

    @Override 
    public String getAccessTokenDto(AccessTokenDto accessTokenDto) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDto));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GithubUserInfoDto getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization","token "+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUserInfoDto githubUserInfo = JSON.parseObject(string, GithubUserInfoDto.class);
            return githubUserInfo;
        } catch (IOException e) {
        }
        return null;
    }
}
