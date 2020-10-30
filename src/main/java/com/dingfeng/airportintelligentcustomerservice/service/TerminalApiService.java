package com.dingfeng.airportintelligentcustomerservice.service;

import com.dingfeng.airportintelligentcustomerservice.pojo.terminal.FaceSearchOutput;

public interface TerminalApiService {
    FaceSearchOutput getFace(int id);
}
