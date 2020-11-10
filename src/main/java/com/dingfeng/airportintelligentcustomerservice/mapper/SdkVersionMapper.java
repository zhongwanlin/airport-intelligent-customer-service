package com.dingfeng.airportintelligentcustomerservice.mapper;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper
public interface SdkVersionMapper {
    /**
     * 设备Sdk版本列表
     * 
     * @param query
     * @return
     */
    List<SdkVersionInfo> getList(QuerySdkVersionInput query);

    /**
     * 查询设备Sdk版本详情
     * 
     * @param id
     * @return
     */
    SdkVersionInfo getById(int id);

    /**
     * 新增设备Sdk版本
     * 
     * @param orgInput
     * @return
     */
    int add(SdkVersionInput input);

    /**
     * 修改设备Sdk版本
     * 
     * @param roleInput
     * @return
     */
    int edit(SdkVersionInput input);

    /**
     * 删除设备Sdk版本
     * 
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 判断版本是否存在
     * 
     * @param version
     * @param id
     * @return
     */
    int exitVersion(String version, int id);

    /**
     * 版本是否被使用
     * 
     * @param version
     * @return
     */
    int usedVersion(String version);
}
