package com.yaoxiang.client;

import com.yaoxiang.bo.BiBaseReqBo;
import com.yaoxiang.bo.BiUserListReqBo;
import com.yaoxiang.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

//@FeignClient(name = "myClient", url = "https://api.ozhousemm.com", configuration = FeignClientConfig.class)
@FeignClient(name = "biClient",url = "${bi.host}", configuration = FeignClientConfig.class)
public interface BiHttpClient {
    @PostMapping("/public-api/user/list")
    Object userList(@RequestBody BiUserListReqBo bo);

    @PostMapping("/public-api/user-group/list")
    Object userGroupList(@RequestBody BiBaseReqBo bo);
}
