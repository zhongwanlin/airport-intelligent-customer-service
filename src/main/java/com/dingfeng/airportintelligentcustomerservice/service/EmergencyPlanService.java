package com.dingfeng.airportintelligentcustomerservice.service;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.github.pagehelper.PageInfo;

public interface EmergencyPlanService {
    /**
     * 应急预案列表
     * 
     * @param query
     * @return
     */
    PageInfo<EmergencyPlanInfo> getList(QueryEmergencyPlanInput query);

    /**
     * 查询应急预案详情
     * 
     * @param id
     * @return
     */
    Result getById(int id);

    /**
     * 新增应急预案
     * 
     * @param orgInput
     * @return
     */
    Result add(EmergencyPlanInput input);

    /**
     * 修改应急预案
     * 
     * @param roleInput
     * @return
     */
    Result edit(EmergencyPlanInput input);

    /**
     * 删除应急预案
     * 
     * @param id
     * @return
     */
    Result delete(int id);

    /**
     * 启用设备版本
     * 
     * @param id
     * @return
     */
    Result enable(int id);

    /**
     * 禁用设备版本
     * 
     * @param id
     * @return
     */
    Result disable(int id);
}
