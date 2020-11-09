package com.dingfeng.airportintelligentcustomerservice.service.impl;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.mapper.MachineMapper;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.dingfeng.airportintelligentcustomerservice.service.MachineService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineServiceImpl implements MachineService {

    @Autowired
    MachineMapper machineMapper;

    @Override
    public PageInfo<MachineInfo> getList(QueryMachineInput query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<MachineInfo> machineInfos = machineMapper.getList();
        return new PageInfo<>(machineInfos);
    }

    @Override
    public Result getById(int id) {
        MachineInfo machineInfo = machineMapper.getById(id);
        if (machineInfo != null) {
            return Result.Success("查询成功", machineInfo);
        }
        return Result.Error("查询没有数据");
    }

    @Override
    public Result add(MachineInput input) {
        if (input == null) {
            return Result.Error("参数为空");
        }
        if (machineMapper.exitMachine(input.getName(), input.getMac_id(), 0) > 0) {
            return Result.Error("设备" + input.getName() + "已存在");
        }

        if (machineMapper.add(input) > 0) {
            return Result.Success("新增成功");
        }

        return Result.Error("新增失败");
    }

    @Override
    public Result edit(MachineInput input) {
        if (input == null) {
            return Result.Error("参数为空");
        }
        if (machineMapper.exitMachine(input.getName(), input.getMac_id(), input.getId()) > 0) {
            return Result.Error("设备" + input.getName() + "已存在");
        }

        if (machineMapper.edit(input) > 0) {
            return Result.Success("新增成功");
        }

        return Result.Error("新增失败");
    }

    @Override
    public Result delete(int id) {
        MachineInfo machineInfo = machineMapper.getById(id);
        if (machineInfo.getDep_status() == 3) {
            return Result.Success("该设备已被激活，不能删除");
        }
        machineMapper.delete(id);
        return Result.Success("删除成功");
    }

}
