package com.dingfeng.airportintelligentcustomerservice.service.impl;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.mapper.SdkVersionMapper;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.dingfeng.airportintelligentcustomerservice.service.SdkVersionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SdkVersionServiceImpl implements SdkVersionService {

    @Autowired
    SdkVersionMapper sdkVersionMapper;

    /**
     * 设备Sdk版本列表
     * 
     * @param query
     * @return
     */
    @Override
    public PageInfo<SdkVersionInfo> getList(QuerySdkVersionInput query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<SdkVersionInfo> sdkVersionInfos = sdkVersionMapper.getList(query);
        return new PageInfo<>(sdkVersionInfos);
    }

    /**
     * 查询设备Sdk版本详情
     * 
     * @param id
     * @return
     */
    @Override
    public Result getById(int id) {
        SdkVersionInfo sdkVersionInfo = sdkVersionMapper.getById(id);
        if (sdkVersionInfo != null) {
            return Result.Success("查询成功", sdkVersionInfo);
        }
        return Result.Error("查询没有数据");
    }

    /**
     * 新增设备Sdk版本
     * 
     * @param orgInput
     * @return
     */
    @Override
    public Result add(SdkVersionInput input) {
        if (input == null) {
            return Result.Error("参数为空");
        }
        if (input.getVersion() == "") {
            return Result.Error("参数名称不能为空");
        }
        if (sdkVersionMapper.exitVersion(input.getVersion(), 0) > 0) {
            return Result.Error("版本" + input.getVersion() + "已存在");
        }

        if (sdkVersionMapper.add(input) > 0) {
            return Result.Success("新增成功");
        }

        return Result.Error("新增失败");
    }

    /**
     * 修改设备Sdk版本
     * 
     * @param roleInput
     * @return
     */
    @Override
    public Result edit(SdkVersionInput input) {
        if (input == null) {
            return Result.Error("参数为空");
        }
        if (input.getVersion() == "") {
            return Result.Error("参数名称不能为空");
        }
        if (sdkVersionMapper.exitVersion(input.getVersion(), input.getId()) > 0) {
            return Result.Error("版本" + input.getVersion() + "已存在");
        }

        if (sdkVersionMapper.edit(input) > 0) {
            return Result.Success("修改成功");
        }

        return Result.Error("修改失败");
    }

    /**
     * 删除设备Sdk版本
     * 
     * @param id
     * @return
     */
    @Override
    public Result delete(int id) {

        SdkVersionInfo sdkVersionInfo = sdkVersionMapper.getById(id);
        if (sdkVersionInfo == null) {
            return Result.Error("删除失败，没找到版本信息");
        }
        if (sdkVersionMapper.usedVersion(sdkVersionInfo.getVersion()) > 0) {
            return Result.Error("该版本已被使用，不能删除");
        }

        sdkVersionMapper.delete(id);
        return Result.Success("删除成功");

    }
}
