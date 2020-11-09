package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MachineInput {
    private int id;
    private String name;
    private String mac_id;
    private int dep_status;
    private String version;
    private int area_id;
}
