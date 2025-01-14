package com.yaoxiang.service;

import com.yaoxiang.bo.BiBaseReqBo;
import com.yaoxiang.bo.BiUserListReqBo;
import com.yaoxiang.client.BiHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BiApiService {

    @Resource
    private BiHttpClient biHttpClient;

    @Value("${bi.token}")
    private String token;

    public Object  userList() {
        BiUserListReqBo bo = BiUserListReqBo.builder().userPropertyType(0).token(token).build();

        Object response = biHttpClient.userList(bo);
        return response;
    }

    public Object  userGroupList() {
        BiBaseReqBo bo = BiBaseReqBo.builder().token(token).build();

        Object response = biHttpClient.userGroupList(bo);
        return response;
    }
}

