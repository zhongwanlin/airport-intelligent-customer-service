package com.dingfeng.airportintelligentcustomerservice.service;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.github.pagehelper.PageInfo;

public interface OrganizationService {
    /**
     * 组织架构列表
     * 
     * @param query
     * @return
     */
    PageInfo<OrganizationInfo> getList(QueryOrganizationInput query);

    /**
     * 查询组织架构详情
     * 
     * @param id
     * @return
     */
    Result getById(int id);

    /**
     * 新增组织架构
     * 
     * @param orgInput
     * @return
     */
    Result add(OrganizationInput orgInput);

    /**
     * 修改组织架构
     * 
     * @param roleInput
     * @return
     */
    Result edit(OrganizationInput orgInput);

    /**
     * 禁用组织架构
     * 
     * @param id
     * @return
     */
    Result disable(int id);

    /**
     * 启用组织架构
     * 
     * @param id
     * @return
     */
    Result enable(int id);

    /**
     * 删除组织架构
     * 
     * @param id
     * @return
     */
    Result delete(int id);
}
