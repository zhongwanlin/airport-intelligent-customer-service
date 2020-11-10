package com.dingfeng.airportintelligentcustomerservice.controller.sysManage;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.IdInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.dingfeng.airportintelligentcustomerservice.service.ParamConfigService;
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
* 参数配置管理接口
*/
@Api(value = "/org", description = "参数配置管理接口")
@RestController
public class ParamConfigController {
    @Autowired
    ParamConfigService paramConfigService;

    @ApiParam
    @ApiOperation(value = "参数配置列表")
    @GetMapping(value = "sys/config/list")
    @ResponseBody
    public PageInfo<ParamConfigInfo> getList(QueryParamConfigInput query) {
        return paramConfigService.getList(query);
    }

    @GetMapping(value = "sys/config/get")
    @ApiParam
    @ApiOperation(value = "参数配置详情")
    @ResponseBody
    public Result getById(int id) {
        return paramConfigService.getById(id);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "新增参数配置", notes = "")
    @ApiParam
    @PostMapping(value = "sys/config/add")
    @ResponseBody
    public Result add(@RequestBody ParamConfigInput input) {
        return paramConfigService.add(input);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "修改参数配置", notes = "")
    @ApiParam
    @PostMapping(value = "sys/config/edit")
    @ResponseBody
    public Result edit(@RequestBody ParamConfigInput input) {
        return paramConfigService.edit(input);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "删除参数配置", notes = "")
    @ApiParam
    @PostMapping(value = "sys/config/delete")
    @ResponseBody
    public Result delete(@RequestBody IdInput id) {
        return paramConfigService.delete(id.getId());
    }
}
