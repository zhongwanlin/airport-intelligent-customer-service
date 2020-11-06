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

@RestController
public class AreaController {

    @Autowired
    AreaService areaService;

    @GetMapping
    @ApiParam
    @ApiOperation(value = "区域列表")
    @ResponseBody
    public PageInfo<AreaInfo> getAll(AreaPageInput query) {
        return areaService.getAll(query);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "新增区域", notes = "")
    @ApiParam
    @PostMapping(value = "sys/area/add")
    @ResponseBody
    public Result add(@RequestBody AddAreaInput addAreaInput) {

        Result result = new Result();

        result.setCode("0");
        result.setMsg("SUCCESS");

        return result;
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "修改区域", notes = "")
    @ApiParam
    @PostMapping(value = "sys/area/edit")
    @ResponseBody
    public Result edit(@RequestBody EditAreaInput editAreaInput) {

        Result result = new Result();

        result.setCode("0");
        result.setMsg("SUCCESS");

        return result;
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "删除区域", notes = "")
    @ApiParam
    @PostMapping(value = "sys/area/delete")
    @ResponseBody
    public Result delete(int id) {

        Result result = new Result();

        result.setCode("0");
        result.setMsg("SUCCESS");

        return result;
    }
}
