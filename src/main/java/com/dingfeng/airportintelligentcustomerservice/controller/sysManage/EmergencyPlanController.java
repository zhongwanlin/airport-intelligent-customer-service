package com.dingfeng.airportintelligentcustomerservice.controller.sysManage;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.IdInput;
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

@RestController
@Api(value = "/area", description = "应急预案管理接口")
public class EmergencyPlanController {
    
    @Autowired
    EmergencyPlanService emergencyPlanService;

    @ApiParam
    @ApiOperation(value = "应急预案列表")
    @GetMapping(value = "sys/emergency/list")
    @ResponseBody
    public PageInfo<EmergencyPlanInfo> getList(QueryEmergencyPlanInput query) {
        return emergencyPlanService.getList(query);
    }

    @GetMapping(value = "sys/emergency/get")
    @ApiParam
    @ApiOperation(value = "应急预案详情")
    @ResponseBody
    public Result getById(int id) {
        return emergencyPlanService.getById(id);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "新增应急预案", notes = "")
    @ApiParam
    @PostMapping(value = "sys/emergency/add")
    @ResponseBody
    public Result add(@RequestBody EmergencyPlanInput input) {
        return emergencyPlanService.add(input);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "修改应急预案", notes = "")
    @ApiParam
    @PostMapping(value = "sys/emergency/edit")
    @ResponseBody
    public Result edit(@RequestBody EmergencyPlanInput input) {
        return emergencyPlanService.edit(input);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "删除应急预案", notes = "")
    @ApiParam
    @PostMapping(value = "sys/emergency/delete")
    @ResponseBody
    public Result delete(@RequestBody IdInput id) {
        return emergencyPlanService.delete(id.getId());
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "启用应急预案", notes = "")
    @ApiParam
    @PostMapping(value = "sys/emergency/enable")
    @ResponseBody
    public Result enable(@RequestBody IdInput id) {
        return emergencyPlanService.enable(id.getId());
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "禁用应急预案", notes = "")
    @ApiParam
    @PostMapping(value = "sys/emergency/disable")
    @ResponseBody
    public Result disable(@RequestBody IdInput id) {
        return emergencyPlanService.disable(id.getId());
    }
}
