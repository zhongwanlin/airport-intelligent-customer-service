package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import java.util.List;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmergencyPlanInput {
    private int id;
    private String name;
    private List<EmergencyMac> macInfos;
    private List<String> urls;
}
