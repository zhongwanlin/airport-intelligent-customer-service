package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParamConfigInfo {
    private int id;
    private String name;
    private String title;
    private String value;
    private String tips;
    private int status;
    private Date create_time;
    private Date update_time;
}
