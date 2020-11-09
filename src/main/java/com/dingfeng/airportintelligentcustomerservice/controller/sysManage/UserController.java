package com.dingfeng.airportintelligentcustomerservice.controller.sysManage;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.IdInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.dingfeng.airportintelligentcustomerservice.service.*;

import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 
     * @return
     */
    @ApiOperation(value = "用户列表", notes = "")
    @ApiParam
    @GetMapping(value = "sys/user/list")
    @ResponseBody
    public PageInfo<UserInfo> getList(QueryUserInput query) {

        return userService.getList(query);
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
    @ApiOperation(value = "用户登录", notes = "")
    @ApiParam
    @PostMapping(value = "sys/user/loginOut")
    @ResponseBody
    public Result loginOut(@RequestHeader HttpHeaders headers) {

        List<String> tokens = headers.get("token");
        String token = "";
        if (tokens != null)
            token = tokens.get(0);
        return userService.loginOut(token);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "新增用户", notes = "")
    @ApiParam
    @PostMapping(value = "sys/user/add")
    @ResponseBody
    public Result add(@RequestBody UserInput addUserInput) {

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
    public Result edit(@RequestBody UserInput editUserInput) {

        return userService.edit(editUserInput);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "禁用用户", notes = "")
    @ApiParam
    @PostMapping(value = "sys/user/disable")
    @ResponseBody
    public Result disable(@RequestBody IdInput id) {

        return userService.disable(id.getId());
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "启用用户", notes = "")
    @ApiParam
    @PostMapping(value = "sys/user/enable")
    @ResponseBody
    public Result enable(@RequestBody IdInput id) {

        return userService.enable(id.getId());
    }
}
