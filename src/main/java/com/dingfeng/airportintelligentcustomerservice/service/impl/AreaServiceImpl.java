package com.dingfeng.airportintelligentcustomerservice.service.impl;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.mapper.AreaMapper;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.AreaInfo;
import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.AreaPageInput;
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
    public PageInfo<AreaInfo> getAll(AreaPageInput query) {
        PageHelper.startPage(query.getPageNum(),query.getPageSize());
        List<AreaInfo> areaInfos = areaMapper.getAll();
        return new PageInfo<>(areaInfos);
    }
}
