package com.dingfeng.airportintelligentcustomerservice.mapper;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper
public interface OrganizationMapper {
    /**
     * 查询组织架构信息
     * 
     * @return
     */
    List<OrganizationInfo> getList(QueryOrganizationInput query);

    /**
     * 查询组织架构详情
     * 
     * @param id
     * @return
     */
    OrganizationInfo getById(int id);

    /**
     * 新增组织架构
     * 
     * @param addUserInput
     */
    int add(OrganizationInput addUserInput);

    /**
     * 修改组织架构
     * 
     * @param editUserInput
     */
    int edit(OrganizationInput editUserInput);

    /**
     * 删除组织架构
     * 
     * @param id
     */
    int delete(int id);

    /**
     * 同级不能存在重复名称
     * 
     * @param name
     * @param id
     * @return
     */
    int exitOrganization(String name, int id);
}
