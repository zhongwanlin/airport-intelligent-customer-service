package com.dingfeng.airportintelligentcustomerservice.mapper;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.dingfeng.airportintelligentcustomerservice.pojo.terminal.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper
public interface MachineMapper {
    List<MachineInfo> getList();

    /**
     * 查询设备详情
     * 
     * @param id
     * @return
     */
    MachineInfo getById(int id);

    /**
     * 新增设备
     * 
     * @param input
     * @return
     */
    int add(MachineInput input);

    /**
     * 修改设备
     * 
     * @param input
     * @return
     */
    int edit(MachineInput input);

    /**
     * 删除设备
     * 
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 判断设备是否已经存在
     * 
     * @param name
     * @param mac_id
     * @return
     */
    int exitMachine(String name, String mac_id, int id);

    /**
     * 终端-调⽤模块记录
     * 
     * @param input
     * @return
     */
    int addMachineSdkLog(LogWriteInput input);

    /**
     * 心跳记录
     * 
     * @param intput
     * @return
     */
    int addMachineRunLog(HeartBeatInput input);

    /**
     * 统计设备使用情况
     * 
     * @param query
     * @return
     */
    List<SummaryMachineUsedInfo> summaryMachineUsed(SummaryMachineUsedInput query);

    /**
     * 统计设备模组使用情况
     * 
     * @param query
     * @return
     */
    List<SummaryMachineModelUsedInfo> summaryMachineModelUsed(SummaryMachineModelUsedInput query);

    /**
     * 模组调用日志
     * 
     * @param query
     * @return
     */
    List<MachineSdkLogInfo> logMachine(QueryMachineSdkLogInput query);
}
