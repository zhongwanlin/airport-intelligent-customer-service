package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmergencyPlanInfo {
    private int id;
    private String name;
    private String url;
    private int status;
    private String macInfo;
    private Date create_time;
    private Date update_time;
}
