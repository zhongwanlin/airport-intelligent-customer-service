package com.dingfeng.airportintelligentcustomerservice.controller.sysManage;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.IdInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.dingfeng.airportintelligentcustomerservice.service.OrganizationService;
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
* 组织架构管理接口
*/
@Api(value = "/org", description = "组织架构管理接口")
@RestController
public class OrganizationController {
    @Autowired
    OrganizationService organizationService;

    /**
     * 
     * @return
     */
    @ApiOperation(value = "组织架构列表", notes = "")
    @ApiParam
    @GetMapping(value = "sys/org/list")
    @ResponseBody
    public PageInfo<OrganizationInfo> getList(QueryOrganizationInput query) {

        return organizationService.getList(query);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "新增组织架构", notes = "")
    @ApiParam
    @PostMapping(value = "sys/org/add")
    @ResponseBody
    public Result add(@RequestBody OrganizationInput addUserInput) {

        return organizationService.add(addUserInput);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "修改组织架构", notes = "")
    @ApiParam
    @PostMapping(value = "sys/org/edit")
    @ResponseBody
    public Result edit(@RequestBody OrganizationInput editUserInput) {

        return organizationService.edit(editUserInput);
    }

        /**
     * 
     * @return
     */
    @ApiOperation(value = "删除组织架构", notes = "")
    @ApiParam
    @PostMapping(value = "sys/org/delete")
    @ResponseBody
    public Result delete(@RequestBody IdInput id) {

        Result result = new Result();
        try {
            result = organizationService.delete(id.getId());
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setCode("500");
        }
        return result;
    }

    // /**
    //  * 
    //  * @return
    //  */
    // @ApiOperation(value = "禁用组织架构", notes = "")
    // @ApiParam
    // @PostMapping(value = "sys/org/disable")
    // @ResponseBody
    // public Result disable(@RequestBody IdInput id) {

    //     Result result = new Result();
    //     try {
    //         result = organizationService.disable(id.getId());
    //     } catch (Exception e) {
    //         result.setMsg(e.getMessage());
    //     }
    //     return result;
    // }

    // /**
    //  * 
    //  * @return
    //  */
    // @ApiOperation(value = "启用组织架构", notes = "")
    // @ApiParam
    // @PostMapping(value = "sys/org/enable")
    // @ResponseBody
    // public Result enable(@RequestBody IdInput id) {

    //     Result result = new Result();
    //     try {
    //         result = organizationService.enable(id.getId());
    //     } catch (Exception e) {
    //         result.setMsg(e.getMessage());
    //     }
    //     return result;
    // }
}
