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
        flightInfo.setAirline("HU");
        flightInfo.setAirline_name("海南航空");
        flightInfo.setAirline_id("CHH");
        flightInfo.setAlter_take_off(0);
        flightInfo.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo.setCk_plan_open_time(1604196000);
        flightInfo.setCk_plan_end_time(1604203200);
        flightInfo.setCk_real_open_time(1604196000);
        flightInfo.setCk_real_end_time(1604203200);
        flightInfo.setFlight_no("HU078");
        flightInfo.setFlight_date("20201101");
        flightInfo.setIs_arr_flight(true);
        flightInfo.setIs_international(false);
        flightInfo.setIs_history(false);
        flightInfo.setPlan_end_time(1604205000);
        flightInfo.setPlan_gate_name("5");
        flightInfo.setPlan_open_time(1604203200);
        flightInfo.setPlan_take_off(1604205600);
        flightInfo.setReal_end_time(1604205000);
        flightInfo.setReal_gate_name("5");
        flightInfo.setReal_open_time(1604203200);
        List<String> routCnList = new ArrayList<String>();
        routCnList.add("北京");
        routCnList.add("广州");
        List<String> routEnList = new ArrayList<String>();
        routEnList.add("BeiJing");
        routEnList.add("GuangZhou");
        List<String> routeCodeList = (new ArrayList<String>());
        routeCodeList.add("PEK");
        routeCodeList.add("CAN");
        flightInfo.setRoute_cn_list(routCnList);
        flightInfo.setRoute_en_list(routEnList);
        flightInfo.setRoute_code_list(routeCodeList);
        flightInfo.setStatus(1);
        flightInfo.setExit_gate("10");
        flightInfo.setPlan_landing_time(1604223600);
        flightInfo.setReal_landing_time(1604224200);
        flightInfo.setTerminal("T3");

        FlightInfo flightInfo2 = new FlightInfo();
        flightInfo2.setId(2);
        flightInfo2.setAbn_rsn("");
        flightInfo2.setAbn_status("");
        flightInfo2.setAirline("CA");
        flightInfo2.setAirline_name("国航航空");
        flightInfo2.setAirline_id("CCA");
        flightInfo2.setAlter_take_off(0);
        flightInfo2.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo2.setCk_plan_open_time(1604196000);
        flightInfo2.setCk_plan_end_time(1604203200);
        flightInfo2.setCk_real_open_time(1604196000);
        flightInfo2.setCk_real_end_time(1604203200);
        flightInfo2.setFlight_no("CA078");
        flightInfo2.setFlight_date("20201105");
        flightInfo2.setIs_arr_flight(true);
        flightInfo2.setIs_international(false);
        flightInfo2.setIs_history(false);
        flightInfo2.setPlan_end_time(1604205000);
        flightInfo2.setPlan_gate_name("10");
        flightInfo2.setPlan_open_time(1604203200);
        flightInfo2.setPlan_take_off(1604205600);
        flightInfo2.setReal_end_time(1604205000);
        flightInfo2.setReal_gate_name("10");
        flightInfo2.setReal_open_time(1604203200);
        List<String> routCnList2 = new ArrayList<String>();
        routCnList2.add("北京");
        routCnList2.add("广州");
        List<String> routEnList2 = new ArrayList<String>();
        routEnList2.add("BeiJing");
        routEnList2.add("GuangZhou");
        List<String> routeCodeList2 = (new ArrayList<String>());
        routeCodeList2.add("PEK");
        routeCodeList2.add("CAN");
        flightInfo2.setRoute_cn_list(routCnList2);
        flightInfo2.setRoute_en_list(routEnList2);
        flightInfo2.setRoute_code_list(routeCodeList2);
        flightInfo2.setStatus(3);
        flightInfo2.setExit_gate("6");
        flightInfo2.setPlan_landing_time(1604223600);
        flightInfo2.setReal_landing_time(1604224200);
        flightInfo2.setTerminal("T2");

        FlightInfo flightInfo3 = new FlightInfo();
        flightInfo3.setId(3);
        flightInfo3.setAbn_rsn("");
        flightInfo3.setAbn_status("");
        flightInfo3.setAirline("CZ");
        flightInfo3.setAirline_name("南方航空");
        flightInfo3.setAirline_id("CSN");
        flightInfo3.setAlter_take_off(0);
        flightInfo3.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo3.setCk_plan_open_time(1604196000);
        flightInfo3.setCk_plan_end_time(1604203200);
        flightInfo3.setCk_real_open_time(1604196000);
        flightInfo3.setCk_real_end_time(1604203200);
        flightInfo3.setFlight_no("CZ078");
        flightInfo3.setFlight_date("20201113");
        flightInfo3.setIs_arr_flight(true);
        flightInfo3.setIs_international(false);
        flightInfo3.setIs_history(false);
        flightInfo3.setPlan_end_time(1604205000);
        flightInfo3.setPlan_gate_name("22");
        flightInfo3.setPlan_open_time(1604203200);
        flightInfo3.setPlan_take_off(1604205600);
        flightInfo3.setReal_end_time(1604205000);
        flightInfo3.setReal_gate_name("22");
        flightInfo3.setReal_open_time(1604203200);
        List<String> routCnList3 = new ArrayList<String>();
        routCnList3.add("深圳");
        routCnList3.add("北京");
        List<String> routEnList3 = new ArrayList<String>();
        routEnList3.add("ShenZhen");
        routEnList3.add("BeiJing");
        List<String> routeCodeList3 = (new ArrayList<String>());
        routeCodeList3.add("SZX");
        routeCodeList3.add("PEK");
        flightInfo3.setRoute_cn_list(routCnList3);
        flightInfo3.setRoute_en_list(routEnList3);
        flightInfo3.setRoute_code_list(routeCodeList3);
        flightInfo3.setStatus(7);
        flightInfo3.setExit_gate("5");
        flightInfo3.setPlan_landing_time(1604223600);
        flightInfo3.setReal_landing_time(1604224200);
        flightInfo3.setTerminal("T3");

        List<FlightInfo> flightInfos = new ArrayList<FlightInfo>();

        flightInfos.add(flightInfo);
        flightInfos.add(flightInfo2);
        flightInfos.add(flightInfo3);
        flightResult.setData(flightInfos);

        return flightResult;
    }

}
