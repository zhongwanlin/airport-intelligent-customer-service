package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SdkVersionInfo {
    private int id;
    private String version;
    private String md5;
    private String url;
    private String info;
    private int status;
    private Date create_time;
    private Date update_time;
}
