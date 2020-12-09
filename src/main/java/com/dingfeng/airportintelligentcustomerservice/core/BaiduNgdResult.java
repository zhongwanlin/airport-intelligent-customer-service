package com.dingfeng.airportintelligentcustomerservice.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaiduNgdResult {
    private String code;
    private long time;
    private Object data;
    private String msg;
}
