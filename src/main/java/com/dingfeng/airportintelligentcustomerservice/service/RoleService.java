package com.dingfeng.airportintelligentcustomerservice.service;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.github.pagehelper.PageInfo;

public interface RoleService {

    /**
     * 角色列表
     * 
     * @param query
     * @return
     */
    PageInfo<RoleInfo> getAll(QueryRoleInput query);

    /**
     * 查询角色详情
     * 
     * @param id
     * @return
     */
    Result getById(int id);

    /**
     * 新增角色
     * 
     * @param roleInput
     * @return
     */
    Result add(RoleInput roleInput);

    /**
     * 修改角色
     * 
     * @param roleInput
     * @return
     */
    Result edit(RoleInput roleInput);

    /**
     * 禁用角色
     * 
     * @param id
     * @return
     */
    Result disable(int id);

    /**
     * 启用角色
     * 
     * @param id
     * @return
     */
    Result enable(int id);
}
