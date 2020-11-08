package com.dingfeng.airportintelligentcustomerservice.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDto {
    
    private int id;

    @JsonIgnore
    private String create_time;

    public String getCreate_time() {
        if (create_time == null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            return dateFormat.format(date);
        }
        return create_time;
    }

    public void setCreate_time(String createTime) {
        create_time = createTime;
    }

    @JsonIgnore
    private String update_time;

    public String getUpdate_time() {
        if (update_time == null) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            return dateFormat.format(date);
        }
        return update_time;
    }

    public void setUpdate_time(String updateTime) {
        update_time = updateTime;
    }
}
