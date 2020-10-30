package com.dingfeng.airportintelligentcustomerservice.service.impl;

import com.dingfeng.airportintelligentcustomerservice.mapper.TerminalApiMapper;
import com.dingfeng.airportintelligentcustomerservice.pojo.terminal.FaceSearchOutput;
import com.dingfeng.airportintelligentcustomerservice.service.TerminalApiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminalApiServiceImpl implements TerminalApiService {

    @Autowired
    TerminalApiMapper terminalApiMapper;

    @Override
    public FaceSearchOutput getFace(int id) {
        return terminalApiMapper.getFace(id);
    }

}
