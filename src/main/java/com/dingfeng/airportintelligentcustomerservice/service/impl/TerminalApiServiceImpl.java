package com.dingfeng.airportintelligentcustomerservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        FlightSearchResult result = mockFlightSearchResult();

        if (result != null) {
            List<FlightInfo> flightResult = result.getData();
            if (flightResult != null) {
                List<FlightInfo> flightInfos = flightResult.stream()
                        .filter(f -> f.getFlight_no().toLowerCase().contains(flightNo.toLowerCase()))
                        .collect(Collectors.toList());

                if (flightInfos != null && flightInfos.size() > 0) {
                    result.setData(flightInfos);
                } else {
                    result.setError_msg("没找到航班信息");
                    result.setError_no(1);
                    result.setRequest_id("");
                    result.setData(null);
                }
            }
        }

        return result;
    }

    private FlightSearchResult mockFlightSearchResult() {
        FlightSearchResult flightResult = new FlightSearchResult();

        flightResult.setError_msg("");
        flightResult.setError_no(0);
        flightResult.setRequest_id("");

        List<FlightInfo> flightInfos = new ArrayList<FlightInfo>();

        flightInfos.add(createFlightInfo1());
        flightInfos.add(createFlightInfo2());
        flightInfos.add(createFlightInfo3());
        flightInfos.add(createFlightInfo4());
        flightInfos.add(createFlightInfo5());
        flightInfos.add(createFlightInfo6());
        flightInfos.add(createFlightInfo7());
        flightInfos.add(createFlightInfo8());
        flightInfos.add(createFlightInfo9());
        flightInfos.add(createFlightInfo10());
        flightInfos.add(createFlightInfo11());
        flightInfos.add(createFlightInfo12());
        flightInfos.add(createFlightInfo13());
        flightInfos.add(createFlightInfo14());
        flightInfos.add(createFlightInfo15());
        flightResult.setData(flightInfos);

        return flightResult;
    }

    private FlightInfo createFlightInfo1() {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setId(1);
        flightInfo.setAbn_rsn("");
        flightInfo.setAbn_status("");
        flightInfo.setAirline("HU");
        flightInfo.setAirline_name("海南航空");
        flightInfo.setAirline_id("CHH");
        flightInfo.setAlter_take_off(0L);
        flightInfo.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo.setCk_plan_open_time(1604196000L);
        flightInfo.setCk_plan_end_time(1604203200L);
        flightInfo.setCk_real_open_time(1604196000L);
        flightInfo.setCk_real_end_time(1604203200L);
        flightInfo.setFlight_no("HU078");
        flightInfo.setFlight_date("20201101");
        flightInfo.setIs_arr_flight(true);
        flightInfo.setIs_international(false);
        flightInfo.setIs_history(false);
        flightInfo.setPlan_end_time(1604205000L);
        flightInfo.setPlan_gate_name("5");
        flightInfo.setPlan_open_time(1604203200L);
        flightInfo.setPlan_take_off(1604205600L);
        flightInfo.setReal_end_time(1604205000L);
        flightInfo.setReal_gate_name("5");
        flightInfo.setReal_open_time(1604203200L);
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
        flightInfo.setPlan_landing_time(1604223600L);
        flightInfo.setReal_landing_time(1604224200L);
        flightInfo.setTerminal("T3");

        return flightInfo;
    }

    private FlightInfo createFlightInfo2() {
        FlightInfo flightInfo2 = new FlightInfo();
        flightInfo2.setId(2);
        flightInfo2.setAbn_rsn("");
        flightInfo2.setAbn_status("");
        flightInfo2.setAirline("CA");
        flightInfo2.setAirline_name("国航航空");
        flightInfo2.setAirline_id("CCA");
        flightInfo2.setAlter_take_off(0L);
        flightInfo2.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo2.setCk_plan_open_time(1604196000L);
        flightInfo2.setCk_plan_end_time(1604203200L);
        flightInfo2.setCk_real_open_time(1604196000L);
        flightInfo2.setCk_real_end_time(1604203200L);
        flightInfo2.setFlight_no("CA078");
        flightInfo2.setFlight_date("20201105");
        flightInfo2.setIs_arr_flight(true);
        flightInfo2.setIs_international(false);
        flightInfo2.setIs_history(false);
        flightInfo2.setPlan_end_time(1604205000L);
        flightInfo2.setPlan_gate_name("10");
        flightInfo2.setPlan_open_time(1604203200L);
        flightInfo2.setPlan_take_off(1604205600L);
        flightInfo2.setReal_end_time(1604205000L);
        flightInfo2.setReal_gate_name("10");
        flightInfo2.setReal_open_time(1604203200L);
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
        flightInfo2.setPlan_landing_time(1604223600L);
        flightInfo2.setReal_landing_time(1604224200L);
        flightInfo2.setTerminal("T2");

        return flightInfo2;
    }

    private FlightInfo createFlightInfo3() {
        FlightInfo flightInfo3 = new FlightInfo();
        flightInfo3.setId(3);
        flightInfo3.setAbn_rsn("");
        flightInfo3.setAbn_status("");
        flightInfo3.setAirline("CZ");
        flightInfo3.setAirline_name("南方航空");
        flightInfo3.setAirline_id("CSN");
        flightInfo3.setAlter_take_off(0L);
        flightInfo3.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo3.setCk_plan_open_time(1604196000L);
        flightInfo3.setCk_plan_end_time(1604203200L);
        flightInfo3.setCk_real_open_time(1604196000L);
        flightInfo3.setCk_real_end_time(1604203200L);
        flightInfo3.setFlight_no("CZ078");
        flightInfo3.setFlight_date("20201113");
        flightInfo3.setIs_arr_flight(true);
        flightInfo3.setIs_international(false);
        flightInfo3.setIs_history(false);
        flightInfo3.setPlan_end_time(1604205000L);
        flightInfo3.setPlan_gate_name("22");
        flightInfo3.setPlan_open_time(1604203200L);
        flightInfo3.setPlan_take_off(1604205600L);
        flightInfo3.setReal_end_time(1604205000L);
        flightInfo3.setReal_gate_name("22");
        flightInfo3.setReal_open_time(1604203200L);
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
        flightInfo3.setPlan_landing_time(1604223600L);
        flightInfo3.setReal_landing_time(1604224200L);
        flightInfo3.setTerminal("T3");

        return flightInfo3;
    }

    private FlightInfo createFlightInfo5() {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setId(1);
        flightInfo.setAbn_rsn("");
        flightInfo.setAbn_status("");
        flightInfo.setAirline("SC");
        flightInfo.setAirline_name("山东航空");
        flightInfo.setAirline_id("CHH");
        flightInfo.setAlter_take_off(0L);
        flightInfo.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo.setCk_plan_open_time(1604196000L);
        flightInfo.setCk_plan_end_time(1604203200L);
        flightInfo.setCk_real_open_time(1604196000L);
        flightInfo.setCk_real_end_time(1604203200L);
        flightInfo.setFlight_no("SC4148 CA4148");
        flightInfo.setFlight_date("20201125");
        flightInfo.setIs_arr_flight(true);
        flightInfo.setIs_international(false);
        flightInfo.setIs_history(false);
        flightInfo.setPlan_end_time(1604205000L);
        flightInfo.setPlan_gate_name("C05");
        flightInfo.setPlan_open_time(1604203200L);
        flightInfo.setPlan_take_off(1604205600L);
        flightInfo.setReal_end_time(1604205000L);
        flightInfo.setReal_gate_name("C05");
        flightInfo.setReal_open_time(1604203200L);
        List<String> routCnList = new ArrayList<String>();
        routCnList.add("北京");
        routCnList.add("重庆");
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
        flightInfo.setExit_gate("C05");
        flightInfo.setPlan_landing_time(1604223600L);
        flightInfo.setReal_landing_time(1604224200L);
        flightInfo.setTerminal("T3");

        return flightInfo;
    }

    private FlightInfo createFlightInfo6() {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setId(1);
        flightInfo.setAbn_rsn("");
        flightInfo.setAbn_status("");
        flightInfo.setAirline("CA");
        flightInfo.setAirline_name("中国国际航空");
        flightInfo.setAirline_id("CHH");
        flightInfo.setAlter_take_off(0L);
        flightInfo.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo.setCk_plan_open_time(1604196000L);
        flightInfo.setCk_plan_end_time(1604203200L);
        flightInfo.setCk_real_open_time(1604196000L);
        flightInfo.setCk_real_end_time(1604203200L);
        flightInfo.setFlight_no("CA4148");
        flightInfo.setFlight_date("20201125");
        flightInfo.setIs_arr_flight(true);
        flightInfo.setIs_international(false);
        flightInfo.setIs_history(false);
        flightInfo.setPlan_end_time(1604205000L);
        flightInfo.setPlan_gate_name("C05");
        flightInfo.setPlan_open_time(1604203200L);
        flightInfo.setPlan_take_off(1604205600L);
        flightInfo.setReal_end_time(1604205000L);
        flightInfo.setReal_gate_name("C05");
        flightInfo.setReal_open_time(1604203200L);
        List<String> routCnList = new ArrayList<String>();
        routCnList.add("北京");
        routCnList.add("包头");
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
        flightInfo.setExit_gate("C05");
        flightInfo.setPlan_landing_time(1604223600L);
        flightInfo.setReal_landing_time(1604224200L);
        flightInfo.setTerminal("T3");

        return flightInfo;
    }

    private FlightInfo createFlightInfo7() {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setId(1);
        flightInfo.setAbn_rsn("");
        flightInfo.setAbn_status("");
        flightInfo.setAirline("HU");
        flightInfo.setAirline_name("海南航空");
        flightInfo.setAirline_id("CHH");
        flightInfo.setAlter_take_off(0L);
        flightInfo.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo.setCk_plan_open_time(1604196000L);
        flightInfo.setCk_plan_end_time(1604203200L);
        flightInfo.setCk_real_open_time(1604196000L);
        flightInfo.setCk_real_end_time(1604203200L);
        flightInfo.setFlight_no("HU7251");
        flightInfo.setFlight_date("20201125");
        flightInfo.setIs_arr_flight(true);
        flightInfo.setIs_international(false);
        flightInfo.setIs_history(false);
        flightInfo.setPlan_end_time(1604205000L);
        flightInfo.setPlan_gate_name("41");
        flightInfo.setPlan_open_time(1604203200L);
        flightInfo.setPlan_take_off(1604205600L);
        flightInfo.setReal_end_time(1604205000L);
        flightInfo.setReal_gate_name("41");
        flightInfo.setReal_open_time(1604203200L);
        List<String> routCnList = new ArrayList<String>();
        routCnList.add("北京");
        routCnList.add("温州");
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
        flightInfo.setExit_gate("41");
        flightInfo.setPlan_landing_time(1604223600L);
        flightInfo.setReal_landing_time(1604224200L);
        flightInfo.setTerminal("T2");

        return flightInfo;
    }

    private FlightInfo createFlightInfo8() {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setId(1);
        flightInfo.setAbn_rsn("");
        flightInfo.setAbn_status("");
        flightInfo.setAirline("MU");
        flightInfo.setAirline_name("中国东方航空");
        flightInfo.setAirline_id("CHH");
        flightInfo.setAlter_take_off(0L);
        flightInfo.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo.setCk_plan_open_time(1604196000L);
        flightInfo.setCk_plan_end_time(1604203200L);
        flightInfo.setCk_real_open_time(1604196000L);
        flightInfo.setCk_real_end_time(1604203200L);
        flightInfo.setFlight_no("MU5106");
        flightInfo.setFlight_date("20201125");
        flightInfo.setIs_arr_flight(true);
        flightInfo.setIs_international(false);
        flightInfo.setIs_history(false);
        flightInfo.setPlan_end_time(1604205000L);
        flightInfo.setPlan_gate_name("23");
        flightInfo.setPlan_open_time(1604203200L);
        flightInfo.setPlan_take_off(1604205600L);
        flightInfo.setReal_end_time(1604205000L);
        flightInfo.setReal_gate_name("23");
        flightInfo.setReal_open_time(1604203200L);
        List<String> routCnList = new ArrayList<String>();
        routCnList.add("北京");
        routCnList.add("上海虹桥");
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
        flightInfo.setExit_gate("23");
        flightInfo.setPlan_landing_time(1604223600L);
        flightInfo.setReal_landing_time(1604224200L);
        flightInfo.setTerminal("T2");

        return flightInfo;
    }

    private FlightInfo createFlightInfo9() {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setId(1);
        flightInfo.setAbn_rsn("");
        flightInfo.setAbn_status("");
        flightInfo.setAirline("CA");
        flightInfo.setAirline_name("中国国际航空");
        flightInfo.setAirline_id("CHH");
        flightInfo.setAlter_take_off(0L);
        flightInfo.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo.setCk_plan_open_time(1604196000L);
        flightInfo.setCk_plan_end_time(1604203200L);
        flightInfo.setCk_real_open_time(1604196000L);
        flightInfo.setCk_real_end_time(1604203200L);
        flightInfo.setFlight_no("CA8661");
        flightInfo.setFlight_date("20201125");
        flightInfo.setIs_arr_flight(true);
        flightInfo.setIs_international(false);
        flightInfo.setIs_history(false);
        flightInfo.setPlan_end_time(1604205000L);
        flightInfo.setPlan_gate_name("C07");
        flightInfo.setPlan_open_time(1604203200L);
        flightInfo.setPlan_take_off(1604205600L);
        flightInfo.setReal_end_time(1604205000L);
        flightInfo.setReal_gate_name("C07");
        flightInfo.setReal_open_time(1604203200L);
        List<String> routCnList = new ArrayList<String>();
        routCnList.add("北京");
        routCnList.add("长沙");
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
        flightInfo.setExit_gate("C07");
        flightInfo.setPlan_landing_time(1604223600L);
        flightInfo.setReal_landing_time(1604224200L);
        flightInfo.setTerminal("T3");

        return flightInfo;
    }

    private FlightInfo createFlightInfo10() {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setId(1);
        flightInfo.setAbn_rsn("");
        flightInfo.setAbn_status("");
        flightInfo.setAirline("3U");
        flightInfo.setAirline_name("四川航空股份");
        flightInfo.setAirline_id("CHH");
        flightInfo.setAlter_take_off(0L);
        flightInfo.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo.setCk_plan_open_time(1604196000L);
        flightInfo.setCk_plan_end_time(1604203200L);
        flightInfo.setCk_real_open_time(1604196000L);
        flightInfo.setCk_real_end_time(1604203200L);
        flightInfo.setFlight_no("3U8803");
        flightInfo.setFlight_date("20201125");
        flightInfo.setIs_arr_flight(true);
        flightInfo.setIs_international(false);
        flightInfo.setIs_history(false);
        flightInfo.setPlan_end_time(1604205000L);
        flightInfo.setPlan_gate_name("C19");
        flightInfo.setPlan_open_time(1604203200L);
        flightInfo.setPlan_take_off(1604205600L);
        flightInfo.setReal_end_time(1604205000L);
        flightInfo.setReal_gate_name("C19");
        flightInfo.setReal_open_time(1604203200L);
        List<String> routCnList = new ArrayList<String>();
        routCnList.add("北京");
        routCnList.add("百色");
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
        flightInfo.setExit_gate("C19");
        flightInfo.setPlan_landing_time(1604223600L);
        flightInfo.setReal_landing_time(1604224200L);
        flightInfo.setTerminal("T3");

        return flightInfo;
    }

    private FlightInfo createFlightInfo4() {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setId(1);
        flightInfo.setAbn_rsn("");
        flightInfo.setAbn_status("");
        flightInfo.setAirline("NZ");
        flightInfo.setAirline_name("新西兰航空公司");
        flightInfo.setAirline_id("CHH");
        flightInfo.setAlter_take_off(0L);
        flightInfo.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo.setCk_plan_open_time(1604196000L);
        flightInfo.setCk_plan_end_time(1604203200L);
        flightInfo.setCk_real_open_time(1604196000L);
        flightInfo.setCk_real_end_time(1604203200L);
        flightInfo.setFlight_no("NZ3861");
        flightInfo.setFlight_date("20201125");
        flightInfo.setIs_arr_flight(true);
        flightInfo.setIs_international(false);
        flightInfo.setIs_history(false);
        flightInfo.setPlan_end_time(1604205000L);
        flightInfo.setPlan_gate_name("C28");
        flightInfo.setPlan_open_time(1604203200L);
        flightInfo.setPlan_take_off(1604205600L);
        flightInfo.setReal_end_time(1604205000L);
        flightInfo.setReal_gate_name("C28");
        flightInfo.setReal_open_time(1604203200L);
        List<String> routCnList = new ArrayList<String>();
        routCnList.add("北京");
        routCnList.add("武汉");
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
        flightInfo.setExit_gate("C28");
        flightInfo.setPlan_landing_time(1604223600L);
        flightInfo.setReal_landing_time(1604224200L);
        flightInfo.setTerminal("T3");

        return flightInfo;
    }

    private FlightInfo createFlightInfo11() {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setId(1);
        flightInfo.setAbn_rsn("");
        flightInfo.setAbn_status("");
        flightInfo.setAirline("CA");
        flightInfo.setAirline_name("中国国际航空");
        flightInfo.setAirline_id("CHH");
        flightInfo.setAlter_take_off(0L);
        flightInfo.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo.setCk_plan_open_time(1604196000L);
        flightInfo.setCk_plan_end_time(1604203200L);
        flightInfo.setCk_real_open_time(1604196000L);
        flightInfo.setCk_real_end_time(1604203200L);
        flightInfo.setFlight_no("CA8675");
        flightInfo.setFlight_date("20201125");
        flightInfo.setIs_arr_flight(true);
        flightInfo.setIs_international(false);
        flightInfo.setIs_history(false);
        flightInfo.setPlan_end_time(1604205000L);
        flightInfo.setPlan_gate_name("C25");
        flightInfo.setPlan_open_time(1604203200L);
        flightInfo.setPlan_take_off(1604205600L);
        flightInfo.setReal_end_time(1604205000L);
        flightInfo.setReal_gate_name("C25");
        flightInfo.setReal_open_time(1604203200L);
        List<String> routCnList = new ArrayList<String>();
        routCnList.add("北京");
        routCnList.add("丽江");
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
        flightInfo.setExit_gate("C25");
        flightInfo.setPlan_landing_time(1604223600L);
        flightInfo.setReal_landing_time(1604224200L);
        flightInfo.setTerminal("T3");

        return flightInfo;
    }

    private FlightInfo createFlightInfo12() {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setId(1);
        flightInfo.setAbn_rsn("");
        flightInfo.setAbn_status("");
        flightInfo.setAirline("HO");
        flightInfo.setAirline_name("上海吉祥航空");
        flightInfo.setAirline_id("CHH");
        flightInfo.setAlter_take_off(0L);
        flightInfo.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo.setCk_plan_open_time(1604196000L);
        flightInfo.setCk_plan_end_time(1604203200L);
        flightInfo.setCk_real_open_time(1604196000L);
        flightInfo.setCk_real_end_time(1604203200L);
        flightInfo.setFlight_no("HO3877");
        flightInfo.setFlight_date("20201125");
        flightInfo.setIs_arr_flight(true);
        flightInfo.setIs_international(false);
        flightInfo.setIs_history(false);
        flightInfo.setPlan_end_time(1604205000L);
        flightInfo.setPlan_gate_name("20");
        flightInfo.setPlan_open_time(1604203200L);
        flightInfo.setPlan_take_off(1604205600L);
        flightInfo.setReal_end_time(1604205000L);
        flightInfo.setReal_gate_name("20");
        flightInfo.setReal_open_time(1604203200L);
        List<String> routCnList = new ArrayList<String>();
        routCnList.add("北京");
        routCnList.add("上海虹桥");
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
        flightInfo.setExit_gate("20");
        flightInfo.setPlan_landing_time(1604223600L);
        flightInfo.setReal_landing_time(1604224200L);
        flightInfo.setTerminal("T2");

        return flightInfo;
    }

    private FlightInfo createFlightInfo13() {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setId(1);
        flightInfo.setAbn_rsn("");
        flightInfo.setAbn_status("");
        flightInfo.setAirline("SC");
        flightInfo.setAirline_name("山东航空");
        flightInfo.setAirline_id("CHH");
        flightInfo.setAlter_take_off(0L);
        flightInfo.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo.setCk_plan_open_time(1604196000L);
        flightInfo.setCk_plan_end_time(1604203200L);
        flightInfo.setCk_real_open_time(1604196000L);
        flightInfo.setCk_real_end_time(1604203200L);
        flightInfo.setFlight_no("SC4148 CA4148");
        flightInfo.setFlight_date("20201125");
        flightInfo.setIs_arr_flight(true);
        flightInfo.setIs_international(false);
        flightInfo.setIs_history(false);
        flightInfo.setPlan_end_time(1604205000L);
        flightInfo.setPlan_gate_name("C14");
        flightInfo.setPlan_open_time(1604203200L);
        flightInfo.setPlan_take_off(1604205600L);
        flightInfo.setReal_end_time(1604205000L);
        flightInfo.setReal_gate_name("C14");
        flightInfo.setReal_open_time(1604203200L);
        List<String> routCnList = new ArrayList<String>();
        routCnList.add("北京");
        routCnList.add("包头");
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
        flightInfo.setExit_gate("C14");
        flightInfo.setPlan_landing_time(1604223600L);
        flightInfo.setReal_landing_time(1604224200L);
        flightInfo.setTerminal("T3");

        return flightInfo;
    }

    private FlightInfo createFlightInfo14() {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setId(1);
        flightInfo.setAbn_rsn("");
        flightInfo.setAbn_status("");
        flightInfo.setAirline("HU");
        flightInfo.setAirline_name("芬兰航空公司");
        flightInfo.setAirline_id("CHH");
        flightInfo.setAlter_take_off(0L);
        flightInfo.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo.setCk_plan_open_time(1604196000L);
        flightInfo.setCk_plan_end_time(1604203200L);
        flightInfo.setCk_real_open_time(1604196000L);
        flightInfo.setCk_real_end_time(1604203200L);
        flightInfo.setFlight_no("AY86");
        flightInfo.setFlight_date("20201125");
        flightInfo.setIs_arr_flight(true);
        flightInfo.setIs_international(false);
        flightInfo.setIs_history(false);
        flightInfo.setPlan_end_time(1604205000L);
        flightInfo.setPlan_gate_name("C14");
        flightInfo.setPlan_open_time(1604203200L);
        flightInfo.setPlan_take_off(1604205600L);
        flightInfo.setReal_end_time(1604205000L);
        flightInfo.setReal_gate_name("C14");
        flightInfo.setReal_open_time(1604203200L);
        List<String> routCnList = new ArrayList<String>();
        routCnList.add("北京");
        routCnList.add("赫尔辛基");
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
        flightInfo.setExit_gate("C14");
        flightInfo.setPlan_landing_time(1604223600L);
        flightInfo.setReal_landing_time(1604224200L);
        flightInfo.setTerminal("T3");

        return flightInfo;
    }

    private FlightInfo createFlightInfo15() {
        FlightInfo flightInfo = new FlightInfo();
        flightInfo.setId(1);
        flightInfo.setAbn_rsn("");
        flightInfo.setAbn_status("");
        flightInfo.setAirline("CA");
        flightInfo.setAirline_name("中国国际航空");
        flightInfo.setAirline_id("CHH");
        flightInfo.setAlter_take_off(0L);
        flightInfo.setFlight_key("20190829-QW9793-O-W/Z-201908290735");
        flightInfo.setCk_plan_open_time(1604196000L);
        flightInfo.setCk_plan_end_time(1604203200L);
        flightInfo.setCk_real_open_time(1604196000L);
        flightInfo.setCk_real_end_time(1604203200L);
        flightInfo.setFlight_no("CA4130");
        flightInfo.setFlight_date("20201125");
        flightInfo.setIs_arr_flight(true);
        flightInfo.setIs_international(false);
        flightInfo.setIs_history(false);
        flightInfo.setPlan_end_time(1604205000L);
        flightInfo.setPlan_gate_name("C37");
        flightInfo.setPlan_open_time(1604203200L);
        flightInfo.setPlan_take_off(1604205600L);
        flightInfo.setReal_end_time(1604205000L);
        flightInfo.setReal_gate_name("C37");
        flightInfo.setReal_open_time(1604203200L);
        List<String> routCnList = new ArrayList<String>();
        routCnList.add("北京");
        routCnList.add("重庆");
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
        flightInfo.setExit_gate("C37");
        flightInfo.setPlan_landing_time(1604223600L);
        flightInfo.setReal_landing_time(1604224200L);
        flightInfo.setTerminal("T3");

        return flightInfo;
    }
}
