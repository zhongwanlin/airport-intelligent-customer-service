package com.dingfeng.airportintelligentcustomerservice.service;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.AddRoleInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.EditRoleInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.QueryRoleInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.RoleInfo;
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
    Result add(AddRoleInput roleInput);

    /**
     * 修改角色
     * 
     * @param roleInput
     * @return
     */
    Result edit(EditRoleInput roleInput);

    /**
     * 删除角色
     * 
     * @param id
     * @return
     */
    Result delete(int id);
}
