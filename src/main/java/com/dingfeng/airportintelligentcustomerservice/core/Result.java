package com.dingfeng.airportintelligentcustomerservice.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private String code;
    private String msg;
    private long time;
    private Object data;

    public static Result Error(String msg) {
        Result result = new Result();
        result.setCode("99");
        result.setMsg(msg);

        return result;
    }

    public static Result Success(String msg, Object data) {
        Result result = new Result();
        result.setCode("0");
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result Success(String msg) {
        Result result = new Result();
        result.setCode("0");
        result.setMsg(msg);
        
        return result;
    }
}
