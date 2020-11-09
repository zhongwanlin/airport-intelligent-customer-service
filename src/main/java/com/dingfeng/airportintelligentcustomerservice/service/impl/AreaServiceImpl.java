package com.dingfeng.airportintelligentcustomerservice.service.impl;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.mapper.AreaMapper;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.AreaInfo;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.AreaInput;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.QueryAreaInput;
import com.dingfeng.airportintelligentcustomerservice.service.AreaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaMapper areaMapper;

    @Override
    public PageInfo<AreaInfo> getList(QueryAreaInput query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<AreaInfo> areaInfos = areaMapper.getList(query);
        return new PageInfo<>(areaInfos);
    }

    @Override
    public Result getById(int id) {
        AreaInfo areaInfo = areaMapper.getById(id);
        if (areaInfo != null) {
            return Result.Success("查询成功", areaInfo);
        }
        return Result.Error("查询没有数据");
    }

    @Override
    public Result add(AreaInput input) {
        if (input == null) {
            return Result.Error("参数为空");
        }
        if (input.getName() == "" || input.getE_name() == "") {
            return Result.Error("区域名称不能为空");
        }
        if (areaMapper.exitArea(input.getName(), input.getE_name(), 0) > 0) {
            return Result.Error("设备" + input.getName() + "已存在");
        }

        if (areaMapper.add(input) > 0) {
            return Result.Success("新增成功");
        }

        return Result.Error("新增失败");
    }

    @Override
    public Result edit(AreaInput input) {
        if (input == null) {
            return Result.Error("参数为空");
        }
        if (input.getName() == "" || input.getE_name() == "") {
            return Result.Error("区域名称不能为空");
        }
        if (areaMapper.exitArea(input.getName(), input.getE_name(), input.getId()) > 0) {
            return Result.Error("区域名称" + input.getName() + "已存在");
        }

        if (areaMapper.edit(input) > 0) {
            return Result.Success("修改成功");
        }

        return Result.Error("修改失败");
    }

    @Override
    public Result delete(int id) {
        areaMapper.delete(id);
        return Result.Success("删除成功");
    }
}
