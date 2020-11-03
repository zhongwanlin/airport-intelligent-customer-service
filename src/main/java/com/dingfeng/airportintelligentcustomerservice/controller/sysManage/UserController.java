package com.dingfeng.airportintelligentcustomerservice.controller.sysManage;

import com.dingfeng.airportintelligentcustomerservice.config.ApiUrlConfig;
import com.dingfeng.airportintelligentcustomerservice.core.Result2;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.dingfeng.airportintelligentcustomerservice.service.*;

import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/*
* 用户管理接口
*/
@Api(value = "/user", description = "用户管理接口")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApiUrlConfig apiUrlConfig;

    /**
     * 
     * @return
     */
    @ApiOperation(value = "用户列表", notes = "")
    @ApiParam
    @GetMapping(value = "api/user/list")
    @ResponseBody
    public PageInfo<UserInfo> getUserList(QueryUserInput query) {

        return userService.getAllUser();
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "RestTemplate测试", notes = "")
    @ApiParam
    @GetMapping(value = "api/user/get")
    @ResponseBody
    public Result2 get() {

        String apiURL = apiUrlConfig.getBaiduVoiceApi();
        return restTemplate.getForObject(apiURL, Result2.class);
    }

}
