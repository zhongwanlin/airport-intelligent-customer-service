package com.dingfeng.airportintelligentcustomerservice.service;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.github.pagehelper.PageInfo;

public interface SdkVersionService {
    /**
     * 设备Sdk版本列表
     * 
     * @param query
     * @return
     */
    PageInfo<SdkVersionInfo> getList(QuerySdkVersionInput query);

    /**
     * 查询设备Sdk版本详情
     * 
     * @param id
     * @return
     */
    Result getById(int id);

    /**
     * 新增设备Sdk版本
     * 
     * @param orgInput
     * @return
     */
    Result add(SdkVersionInput input);

    /**
     * 修改设备Sdk版本
     * 
     * @param roleInput
     * @return
     */
    Result edit(SdkVersionInput input);

    /**
     * 删除设备Sdk版本
     * 
     * @param id
     * @return
     */
    Result delete(int id);
}
