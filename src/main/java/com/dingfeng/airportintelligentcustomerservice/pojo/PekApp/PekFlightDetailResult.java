package com.dingfeng.airportintelligentcustomerservice.pojo.PekApp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PekFlightDetailResult {
    private String code;
    private String msg;
    private PekFlightDetail rst;
}
