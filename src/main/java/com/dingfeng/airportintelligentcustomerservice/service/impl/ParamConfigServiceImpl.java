package com.dingfeng.airportintelligentcustomerservice.service.impl;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.mapper.ParamConfigMapper;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.*;
import com.dingfeng.airportintelligentcustomerservice.service.ParamConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParamConfigServiceImpl implements ParamConfigService {

    @Autowired
    ParamConfigMapper paramConfigMapper;

    @Override
    public PageInfo<ParamConfigInfo> getList(QueryParamConfigInput query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<ParamConfigInfo> paramConfigInfos = paramConfigMapper.getList(query);
        return new PageInfo<>(paramConfigInfos);
    }

    @Override
    public Result getById(int id) {
        ParamConfigInfo paramConfigInfo = paramConfigMapper.getById(id);
        if (paramConfigInfo != null) {
            return Result.Success("查询成功", paramConfigInfo);
        }
        return Result.Error("查询没有数据");
    }

    @Override
    public Result add(ParamConfigInput input) {
        if (input == null) {
            return Result.Error("参数为空");
        }
        if (input.getName() == "") {
            return Result.Error("参数名称不能为空");
        }
        if (paramConfigMapper.exitParamConfig(input.getName(), 0) > 0) {
            return Result.Error("参数名称" + input.getName() + "已存在");
        }

        if (paramConfigMapper.add(input) > 0) {
            return Result.Success("新增成功");
        }

        return Result.Error("新增失败");
    }

    @Override
    public Result edit(ParamConfigInput input) {
        if (input == null) {
            return Result.Error("参数为空");
        }
        if (input.getName() == "") {
            return Result.Error("参数名称不能为空");
        }
        if (paramConfigMapper.exitParamConfig(input.getName(), input.getId()) > 0) {
            return Result.Error("参数名称" + input.getName() + "已存在");
        }

        if (paramConfigMapper.edit(input) > 0) {
            return Result.Success("修改成功");
        }

        return Result.Error("修改失败");
    }

    @Override
    public Result delete(int id) {
        paramConfigMapper.delete(id);
        return Result.Success("删除成功");
    }

}
