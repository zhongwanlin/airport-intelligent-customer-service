package com.dingfeng.airportintelligentcustomerservice.mapper;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper
public interface AreaMapper {
    List<AreaInfo> getList(QueryAreaInput query);

    /**
     * 查询设备详情
     * 
     * @param id
     * @return
     */
    AreaInfo getById(int id);

    /**
     * 新增设备
     * 
     * @param input
     * @return
     */
    int add(AreaInput input);

    /**
     * 修改设备
     * 
     * @param input
     * @return
     */
    int edit(AreaInput input);

    /**
     * 删除设备
     * 
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 判断区域是否存在
     * 
     * @param name
     * @param e_name
     * @param id
     * @return
     */
    int exitArea(String name, String e_name, int id);
}
