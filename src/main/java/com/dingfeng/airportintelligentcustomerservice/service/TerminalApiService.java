package com.dingfeng.airportintelligentcustomerservice.service;

import com.dingfeng.airportintelligentcustomerservice.pojo.terminal.*;

public interface TerminalApiService {
    FaceSearchOutput getFace(int id);

    /**
     * 航班查询
     * 
     * @param flightNo
     * @return
     */
    FlightSearchResult getFlight(String flightNo);
}
