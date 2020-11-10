package com.dingfeng.airportintelligentcustomerservice.mapper;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper
public interface ParamConfigMapper {
    /**
     * 参数配置列表
     * 
     * @param query
     * @return
     */
    List<ParamConfigInfo> getList(QueryParamConfigInput query);

    /**
     * 查询参数配置详情
     * 
     * @param id
     * @return
     */
    ParamConfigInfo getById(int id);

    /**
     * 新增参数配置
     * 
     * @param orgInput
     * @return
     */
    int add(ParamConfigInput orgInput);

    /**
     * 修改参数配置
     * 
     * @param roleInput
     * @return
     */
    int edit(ParamConfigInput orgInput);

    /**
     * 删除参数配置
     * 
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 是否已存在的配置参数
     * 
     * @param name
     * @param id
     * @return
     */
    int exitParamConfig(String name, int id);
}
