package com.dingfeng.airportintelligentcustomerservice.service;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.dingfeng.airportintelligentcustomerservice.pojo.terminal.*;
import com.github.pagehelper.PageInfo;

public interface MachineService {
    /**
     * 设备列表
     * 
     * @param query
     * @return
     */
    PageInfo<MachineInfo> getList(QueryMachineInput query);

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
    Result add(MachineInput input);

    /**
     * 修改设备
     * 
     * @param input
     * @return
     */
    Result edit(MachineInput input);

    /**
     * 删除设备
     * 
     * @param id
     * @return
     */
    Result delete(int id);

    /**
     * 调⽤模块记录
     * 
     * @param input
     * @return
     */
    Result addMachineSdkLog(LogWriteInput input);
}
