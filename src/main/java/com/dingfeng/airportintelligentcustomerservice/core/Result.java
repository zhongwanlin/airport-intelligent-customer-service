package com.dingfeng.airportintelligentcustomerservice.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private String code;
    private String msg;
    private int time;
    private Object data;
}
