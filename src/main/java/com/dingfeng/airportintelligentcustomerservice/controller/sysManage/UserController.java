package com.dingfeng.airportintelligentcustomerservice.controller.sysManage;

import com.dingfeng.airportintelligentcustomerservice.config.ApiUrlConfig;
import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.dingfeng.airportintelligentcustomerservice.service.*;

import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @GetMapping(value = "sys/user/list")
    @ResponseBody
    public PageInfo<UserInfo> getUserList(QueryUserInput query) {

        return userService.getAllUser(query);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "用户登录", notes = "")
    @ApiParam
    @PostMapping(value = "sys/user/login")
    @ResponseBody
    public Result login(@RequestBody LoginInput loginInput) {

        return userService.login(loginInput);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "新增用户", notes = "")
    @ApiParam
    @PostMapping(value = "sys/user/add")
    @ResponseBody
    public Result add(@RequestBody AddUserInput addUserInput) {

        return userService.add(addUserInput);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "修改用户", notes = "")
    @ApiParam
    @PostMapping(value = "sys/user/edit")
    @ResponseBody
    public Result edit(@RequestBody EditUserInput editUserInput) {

        return userService.edit(editUserInput);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "删除用户", notes = "")
    @ApiParam
    @PostMapping(value = "sys/user/delete")
    @ResponseBody
    public Result delete(int id) {

        return userService.delete(id);
    }
}
