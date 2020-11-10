package com.dingfeng.airportintelligentcustomerservice.controller.sysManage;

import com.dingfeng.airportintelligentcustomerservice.service.SdkVersionService;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.IdInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/*
* Sdk版本管理接口
*/
@Api(value = "/version", description = "版本管理接口")
@RestController
public class SdkVersionController {
    @Autowired
    SdkVersionService sdkVersionService;

    @ApiParam
    @ApiOperation(value = "版本列表")
    @GetMapping(value = "sys/version/list")
    @ResponseBody
    public PageInfo<SdkVersionInfo> getList(QuerySdkVersionInput query) {
        return sdkVersionService.getList(query);
    }

    @GetMapping(value = "sys/version/get")
    @ApiParam
    @ApiOperation(value = "版本详情")
    @ResponseBody
    public Result getById(int id) {
        return sdkVersionService.getById(id);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "新增版本", notes = "")
    @ApiParam
    @PostMapping(value = "sys/version/add")
    @ResponseBody
    public Result add(@RequestBody SdkVersionInput input) {
        return sdkVersionService.add(input);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "修改版本", notes = "")
    @ApiParam
    @PostMapping(value = "sys/version/edit")
    @ResponseBody
    public Result edit(@RequestBody SdkVersionInput input) {
        return sdkVersionService.edit(input);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "删除版本", notes = "")
    @ApiParam
    @PostMapping(value = "sys/version/delete")
    @ResponseBody
    public Result delete(@RequestBody IdInput id) {
        return sdkVersionService.delete(id.getId());
    }
}
