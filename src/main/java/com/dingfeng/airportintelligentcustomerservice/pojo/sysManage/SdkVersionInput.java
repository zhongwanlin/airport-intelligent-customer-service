package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SdkVersionInput {
    private int id;
    private String version;
    private String md5;
    private String url;
    private String info;
}
