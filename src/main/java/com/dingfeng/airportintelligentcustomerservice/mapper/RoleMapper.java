package com.dingfeng.airportintelligentcustomerservice.mapper;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper
public interface RoleMapper {
    /**
     * 查询角色信息
     * 
     * @return
     */
    List<RoleInfo> getAll(QueryRoleInput query);

    /**
     * 查询角色详情信息
     * 
     * @param id
     * @return
     */
    RoleInfo getById(int id);

    /**
     * 新增角色
     * 
     * @param roleInput
     * @return
     */
    int add(RoleInput roleInput);

    /**
     * 修改角色
     * 
     * @param roleInput
     * @return
     */
    int edit(RoleInput roleInput);

    /**
     * 禁用角色
     * 
     * @param id
     * @return
     */
    int disable(int id);

    /**
     * 启用角色
     * 
     * @param id
     * @return
     */
    int enable(int id);

    /***
     * 角色名是否存在
     * 
     * @param roleName
     * @return
     */
    int exitRole(String name, int id);

    /**
     * 角色是否被使用
     * 
     * @param id
     * @return
     */
    int usedRole(int id);
}
