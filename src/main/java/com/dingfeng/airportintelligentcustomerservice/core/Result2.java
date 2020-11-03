package com.dingfeng.airportintelligentcustomerservice.core;

import org.apache.ibatis.ognl.ObjectElementsAccessor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result2 {
    private String code;
    private String message;
    private Object data;
}
