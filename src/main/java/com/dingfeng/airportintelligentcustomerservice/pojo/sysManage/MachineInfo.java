package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MachineInfo {
    private int id;
    private String name;
    private String mac_id;
    private int area_id;
    private String areaName;
    /**
     * 1:入场，2：撤场，3激活
     */
    private int dep_status;
    private String version;
    private int status;
    private Date create_time;
    private Date update_time;
}
