package com.dingfeng.airportintelligentcustomerservice.service.impl;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.mapper.RoleMapper;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.dingfeng.airportintelligentcustomerservice.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public PageInfo<RoleInfo> getAll(QueryRoleInput query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<RoleInfo> roleInfos = roleMapper.getAll(query);
        return new PageInfo<>(roleInfos);
    }

    @Override
    public Result add(RoleInput roleInput) {
        if (roleInput == null) {
            return Result.Error("参数为空");
        }
        if (roleMapper.exitRole(roleInput.getName(), 0) > 0) {
            return Result.Error("角色名" + roleInput.getName() + "已存在");
        }

        if (roleMapper.add(roleInput) > 0) {
            return Result.Success("新增成功");
        }

        return Result.Error("新增失败");
    }

    @Override
    public Result edit(RoleInput roleInput) {
        if (roleInput == null) {
            return Result.Error("参数为空");
        }
        if (roleMapper.exitRole(roleInput.getName(), roleInput.getId()) > 0) {
            return Result.Error("用户名" + roleInput.getName() + "已存在");
        }

        if (roleMapper.edit(roleInput) > 0) {
            return Result.Success("修改成功");
        }

        return Result.Error("修改失败");
    }

    @Override
    public Result delete(int id) {
        if (roleMapper.delete(id) > 0) {
            return Result.Success("删除成功");
        }
        return Result.Error("删除失败");
    }

    @Override
    public Result getById(int id) {
        RoleInfo role = roleMapper.getById(id);
        if (role != null) {
            return Result.Success("查询成功", role);
        }
        return Result.Error("查询没有数据");
    }

}
