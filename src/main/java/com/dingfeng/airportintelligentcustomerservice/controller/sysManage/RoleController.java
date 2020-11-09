package com.dingfeng.airportintelligentcustomerservice.controller.sysManage;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.IdInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.dingfeng.airportintelligentcustomerservice.service.RoleService;
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
* 角色管理接口
*/
@Api(value = "/role", description = "角色管理接口")
@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * 
     * @return
     */
    @ApiOperation(value = "角色列表", notes = "")
    @ApiParam
    @GetMapping(value = "sys/role/list")
    @ResponseBody
    public PageInfo<RoleInfo> getRoleList(QueryRoleInput query) {

        return roleService.getAll(query);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "角色详情", notes = "")
    @ApiParam
    @GetMapping(value = "sys/role/get")
    @ResponseBody
    public Result getRole(int id) {

        return roleService.getById(id);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "新增角色", notes = "")
    @ApiParam
    @PostMapping(value = "sys/role/add")
    @ResponseBody
    public Result add(@RequestBody RoleInput roleInput) {

        return roleService.add(roleInput);
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "修改角色", notes = "")
    @ApiParam
    @PostMapping(value = "sys/role/edit")
    @ResponseBody
    public Result edit(@RequestBody RoleInput roleInput) {

        return roleService.edit(roleInput);
    }

        /**
     * 
     * @return
     */
    @ApiOperation(value = "删除角色", notes = "")
    @ApiParam
    @PostMapping(value = "sys/role/delete")
    @ResponseBody
    public Result delete(@RequestBody IdInput id) {

        return roleService.disable(id.getId());
    }

    // /**
    //  * 
    //  * @return
    //  */
    // @ApiOperation(value = "禁用角色", notes = "")
    // @ApiParam
    // @PostMapping(value = "sys/role/disable")
    // @ResponseBody
    // public Result disable(@RequestBody IdInput id) {

    //     return roleService.disable(id.getId());
    // }

    // /**
    //  * 
    //  * @return
    //  */
    // @ApiOperation(value = "启用角色", notes = "")
    // @ApiParam
    // @PostMapping(value = "sys/role/enable")
    // @ResponseBody
    // public Result enable(@RequestBody IdInput id) {

    //     return roleService.enable(id.getId());
    // }
}
