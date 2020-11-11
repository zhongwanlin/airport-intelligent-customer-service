package com.dingfeng.airportintelligentcustomerservice.mapper;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper
public interface EmergencyPlanMapper {
    /**
     * 应急预案列表
     * 
     * @param query
     * @return
     */
    List<EmergencyPlanInfo> getList(QueryEmergencyPlanInput query);

    /**
     * 查询应急预案详情
     * 
     * @param id
     * @return
     */
    EmergencyPlanInfo getById(int id);

    /**
     * 新增应急预案
     * 
     * @param orgInput
     * @return
     */
    int add(EmergencyPlanInfo input);

    /**
     * 修改应急预案
     * 
     * @param roleInput
     * @return
     */
    int edit(EmergencyPlanInfo input);

    /**
     * 删除应急预案
     * 
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 启用设备版本
     * 
     * @param id
     * @return
     */
    int updateStatus(int id, int status);

    /**
     * 设备是否已存在应急预案
     * 
     * @param macName
     * @param id
     * @return
     */
    int exitMac(String macName, int id);
}
