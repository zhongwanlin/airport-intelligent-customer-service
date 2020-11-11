package com.dingfeng.airportintelligentcustomerservice.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.mapper.EmergencyPlanMapper;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.dingfeng.airportintelligentcustomerservice.service.EmergencyPlanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergencyPlanServiceImpl implements EmergencyPlanService {

    @Autowired
    EmergencyPlanMapper emergencyPlanMapper;

    @Override
    public PageInfo<EmergencyPlanInfo> getList(QueryEmergencyPlanInput query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<EmergencyPlanInfo> emergencyPlanInfos = emergencyPlanMapper.getList(query);
        return new PageInfo<>(emergencyPlanInfos);
    }

    @Override
    public Result getById(int id) {
        EmergencyPlanInfo emergencyPlanInfo = emergencyPlanMapper.getById(id);
        if (emergencyPlanInfo != null) {
            return Result.Success("查询成功", emergencyPlanInfo);
        }
        return Result.Error("查询没有数据");
    }

    @Override
    public Result add(EmergencyPlanInput input) {
        if (input == null) {
            return Result.Error("参数为空");
        }
        List<EmergencyMac> macInfos = input.getMacInfos();
        if (macInfos.size() > 0) {
            for (EmergencyMac mac : macInfos) {
                if (emergencyPlanMapper.exitMac(mac.getName(), input.getId()) > 0) {
                    return Result.Error("设备" + mac.getName() + "已存在");
                }
            }
        }
        EmergencyPlanInfo emInfo = new EmergencyPlanInfo();
        emInfo.setName(input.getName());
        emInfo.setUrl(JSON.toJSONString(input.getUrls()));
        emInfo.setMacInfo(JSON.toJSONString(input.getMacInfos()));

        if (emergencyPlanMapper.add(emInfo) > 0) {
            return Result.Success("新增成功");
        }

        return Result.Error("新增失败");
    }

    @Override
    public Result edit(EmergencyPlanInput input) {
        if (input == null) {
            return Result.Error("参数为空");
        }
        List<EmergencyMac> macInfos = input.getMacInfos();
        if (macInfos.size() > 0) {
            for (EmergencyMac mac : macInfos) {
                if (emergencyPlanMapper.exitMac(mac.getName(), input.getId()) > 0) {
                    return Result.Error("设备" + mac.getName() + "已存在");
                }
            }
        }
        EmergencyPlanInfo emInfo = new EmergencyPlanInfo();
        emInfo.setName(input.getName());
        emInfo.setUrl(JSON.toJSONString(input.getUrls()));
        emInfo.setMacInfo(JSON.toJSONString(input.getMacInfos()));
        emInfo.setId(input.getId());
        if (emergencyPlanMapper.edit(emInfo) > 0) {
            return Result.Success("修改成功");
        }

        return Result.Error("修改失败");
    }

    @Override
    public Result delete(int id) {
        emergencyPlanMapper.delete(id);
        return Result.Success("删除成功");
    }

    @Override
    public Result enable(int id) {
        emergencyPlanMapper.updateStatus(id, 1);
        return Result.Success("启用成功");
    }

    @Override
    public Result disable(int id) {
        emergencyPlanMapper.updateStatus(id, 0);
        return Result.Success("禁用成功");
    }
}
