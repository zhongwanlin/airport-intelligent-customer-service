package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AreaInput {
    private int id;
    private String name;
    private String e_name;
    private String gate_map;
    private String e_gate_map;
    private String counter_map;
    private String e_counter_map;
    private String pickup_map;
    private String e_pickup_map;
}
