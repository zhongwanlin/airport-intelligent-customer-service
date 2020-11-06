package com.dingfeng.airportintelligentcustomerservice.mapper;

import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.pojo.sysManage.AreaInfo;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper
public interface AreaMapper {
    List<AreaInfo> getAll();
}
