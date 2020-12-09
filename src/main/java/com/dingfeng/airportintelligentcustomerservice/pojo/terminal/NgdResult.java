package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NgdResult {
    private String code;
    private String msg;
    private NgdData data;
    private long time;
}
