package com.dingfeng.airportintelligentcustomerservice.service;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.github.pagehelper.PageInfo;

public interface AreaService {
    
    PageInfo<AreaInfo> getList(QueryAreaInput query);

    /**
     * 查询设备详情
     * 
     * @param id
     * @return
     */
    Result getById(int id);

    /**
     * 新增设备
     * 
     * @param input
     * @return
     */
    Result add(AreaInput input);

    /**
     * 修改设备
     * 
     * @param input
     * @return
     */
    Result edit(AreaInput input);

    /**
     * 删除设备
     * 
     * @param id
     * @return
     */
    Result delete(int id);
}
