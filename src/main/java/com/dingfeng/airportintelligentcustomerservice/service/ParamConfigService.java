package com.dingfeng.airportintelligentcustomerservice.service;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.github.pagehelper.PageInfo;

public interface ParamConfigService {
    /**
     * 参数配置列表
     * 
     * @param query
     * @return
     */
    PageInfo<ParamConfigInfo> getList(QueryParamConfigInput query);

    /**
     * 查询参数配置详情
     * 
     * @param id
     * @return
     */
    Result getById(int id);

    /**
     * 新增参数配置
     * 
     * @param orgInput
     * @return
     */
    Result add(ParamConfigInput input);

    /**
     * 修改参数配置
     * 
     * @param roleInput
     * @return
     */
    Result edit(ParamConfigInput input);

    /**
     * 删除参数配置
     * 
     * @param id
     * @return
     */
    Result delete(int id);

}
