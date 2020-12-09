package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightDetailQuery {
    private String fltNo;
    private String queryDate;
    private String arrdep;
    private String fltId;
}
