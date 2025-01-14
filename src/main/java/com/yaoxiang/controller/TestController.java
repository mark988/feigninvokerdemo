package com.yaoxiang.controller;

import com.yaoxiang.service.BiApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private BiApiService biApiService;

    @RequestMapping("/v1")
    public Object userList(){
        return  biApiService.userList();
    }

    @RequestMapping("/v2")
    public Object groupList(){
        return  biApiService.userGroupList();
    }

}
