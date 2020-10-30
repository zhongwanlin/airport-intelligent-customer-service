package com.dingfeng.airportintelligentcustomerservice.mapper;

import com.dingfeng.airportintelligentcustomerservice.pojo.terminal.FaceSearchOutput;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper
public interface TerminalApiMapper {
    
    FaceSearchOutput getFace(int id);
}
