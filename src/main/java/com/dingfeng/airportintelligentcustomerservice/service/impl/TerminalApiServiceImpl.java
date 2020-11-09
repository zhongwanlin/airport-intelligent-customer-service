package com.dingfeng.airportintelligentcustomerservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dingfeng.airportintelligentcustomerservice.config.ApiUrlConfig;
import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.mapper.TerminalApiMapper;
import com.dingfeng.airportintelligentcustomerservice.pojo.terminal.FaceSearchOutput;
import com.dingfeng.airportintelligentcustomerservice.pojo.terminal.FlightInfo;
import com.dingfeng.airportintelligentcustomerservice.pojo.terminal.FlightSearchResult;
import com.dingfeng.airportintelligentcustomerservice.service.TerminalApiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TerminalApiServiceImpl implements TerminalApiService {

    @Autowired
    TerminalApiMapper terminalApiMapper;

    @Autowired
    private ApiUrlConfig apiUrlConfig;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public FaceSearchOutput getFace(int id) {
        return terminalApiMapper.getFace(id);
    }

    @Override
    public FlightSearchResult getFlight(String flightNo) {
        // String apiURL = apiUrlConfig.getFlightQueryApi();
        // FlightSearchResult flightSearchResult = restTemplate.getForObject(apiURL,
        // FlightSearchResult.class);
        return mockFlightSearchResult();
    }

    private FlightSearchResult mockFlightSearchResult() {
        FlightSearchResult flightResult = new FlightSearchResult();

        flightResult.setError_msg("");
        flightResult.setError_no(0);
        flightResult.setRequest_id("");

        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setId(1);
        flightInfo.setAbn_rsn("");
        flightInfo.setAbn_status("");
        flightInfo.setAirline_name("");
        flightInfo.setAirline_id("");
        flightInfo.setAlter_take_off(0);
        flightInfo.setFlight_key("");
        flightInfo.setCk_plan_end_time(0);
        flightInfo.setCk_plan_open_time(0);
        flightInfo.setCk_real_end_time(0);
        flightInfo.setCk_real_open_time(0);
        flightInfo.setFlight_no("");
        flightInfo.setFlight_date("");
        flightInfo.setIs_arr_flight(true);
        flightInfo.setIs_history(true);
        flightInfo.setPlan_end_time(0);
        flightInfo.setPlan_gate_name("");
        flightInfo.setPlan_open_time(0);
        flightInfo.setPlan_take_off(0);
        flightInfo.setReal_end_time(0);
        flightInfo.setReal_gate_name("");
        flightInfo.setReal_open_time(0);
        flightInfo.setRoute_cn_list(new ArrayList<String>());
        flightInfo.setRoute_en_list(new ArrayList<String>());
        flightInfo.setRoute_code_list(new ArrayList<String>());
        flightInfo.setStatus(0);
        flightInfo.setExit_gate("");
        flightInfo.setPlan_landing_time(0);
        flightInfo.setReal_landing_time(0);
        flightInfo.setTerminal("");

        List<FlightInfo> flightInfos = new ArrayList<FlightInfo>();

        flightInfos.add(flightInfo);
        flightResult.setData(flightInfos);

        return flightResult;
    }

}
