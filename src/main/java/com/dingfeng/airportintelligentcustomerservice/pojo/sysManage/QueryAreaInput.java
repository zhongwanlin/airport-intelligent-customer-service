package com.dingfeng.airportintelligentcustomerservice.pojo.sysManage;

import com.dingfeng.airportintelligentcustomerservice.core.PageInput;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryAreaInput extends PageInput{
    private String name;
    private String e_name;
}
