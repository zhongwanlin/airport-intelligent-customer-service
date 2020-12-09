package com.dingfeng.airportintelligentcustomerservice.pojo.PekApp;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PekFlightDetail {
    private String airlineNameCn;
    private String arrdep;
    private String bltDisp;
    private String cntDisp;
    private String contractId;
    private String destAirportCn;
    private String destAirportCode;
    private String destSdt;
    private String destTime;
    private String destTimeName;
    private String endCityCn;
    private String firstBltOt;
    private String firstCntOt;
    private String firstGatOt;
    private String fltId;
    private String fltNo;
    private Boolean follow;
    private String gatDisp;
    private String iata;
    private String relFltDesc;
    private String relFltNos;
    private List<String> routeStationSdtArrTime;
    private List<String> routeStationSdtDepTime;
    private String securityDur;
    private String securityState;
    private String startActTime;
    private String startAirportCn;
    private String startAirportCode;
    private String startCityCn;
    private String startSdt;
    private String startTime;
    private String startTimeName;
    private String stateCn;
    private String stateColor;
    private String taxiWait;
    private String term;
    private String terminal;
}
