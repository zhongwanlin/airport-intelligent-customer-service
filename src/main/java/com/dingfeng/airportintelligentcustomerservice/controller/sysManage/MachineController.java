package com.dingfeng.airportintelligentcustomerservice.controller.sysManage;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.IdInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.dingfeng.airportintelligentcustomerservice.service.MachineService;
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

@RestController
@Api(value = "/machine", description = "设备管理接口")
public class MachineController {
    @Autowired
    MachineService machineService;

    @ApiParam
    @ApiOperation(value = "设备列表")
    @GetMapping(value = "sys/machine/list")
    @ResponseBody
    public PageInfo<MachineInfo> getList(QueryMachineInput query) {
        return machineService.getList(query);
    }

    @GetMapping(value = "sys/machine/get")
    @ApiParam
    @ApiOperation(value = "设备详情")
    @ResponseBody
    public Result getById(int id) {
        return machineService.getById(id);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "新增设备", notes = "")
    @ApiParam
    @PostMapping(value = "sys/machine/add")
    @ResponseBody
    public Result add(@RequestBody MachineInput input) {
        return machineService.add(input);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "修改设备", notes = "")
    @ApiParam
    @PostMapping(value = "sys/machine/edit")
    @ResponseBody
    public Result edit(@RequestBody MachineInput input) {
        return machineService.edit(input);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "删除设备", notes = "")
    @ApiParam
    @PostMapping(value = "sys/machine/delete")
    @ResponseBody
    public Result delete(@RequestBody IdInput id) {
        return machineService.delete(id.getId());
    }
}
