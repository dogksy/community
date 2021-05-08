package com.zty.community.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zty.community.dto.AccessTokenDto;
import com.zty.community.dto.GithubUserInfo;
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
            return response.body().string();
        } catch (IOException e) {
        }
        return "";
    }

    public GithubUserInfo getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUserInfo githubUserInfo = JSON.parseObject(string, GithubUserInfo.class);
            return githubUserInfo;
        } catch (IOException e) {
        }
        return null;
    }
}
