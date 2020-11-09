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
public class AreaController {

    @Autowired
    AreaService areaService;

    @GetMapping(value = "sys/area/get")
    @ApiParam
    @ApiOperation(value = "区域列表")
    @ResponseBody
    public PageInfo<AreaInfo> getList(QueryAreaInput query) {
        return areaService.getList(query);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "新增区域", notes = "")
    @ApiParam
    @PostMapping(value = "sys/area/add")
    @ResponseBody
    public Result add(@RequestBody AreaInput input) {
        return areaService.add(input);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "修改区域", notes = "")
    @ApiParam
    @PostMapping(value = "sys/area/edit")
    @ResponseBody
    public Result edit(@RequestBody AreaInput input) {
        return areaService.edit(input);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "删除区域", notes = "")
    @ApiParam
    @PostMapping(value = "sys/area/delete")
    @ResponseBody
    public Result delete(@RequestBody IdInput id) {
        return areaService.delete(id.getId());
    }
}
