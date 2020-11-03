package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("用户")
public class FlightInfo {
    /* 航班 id */
    @ApiModelProperty("航班 id")
    @JsonProperty("id")
    private int id;

    @ApiModelProperty("航班异常原因")
    @JsonProperty("abn_rsn")
    private String abn_rsn;

    @ApiModelProperty("航班异常状态")
    @JsonProperty("abn_status")
    private String abn_status;

    @ApiModelProperty("航空公司名称")
    @JsonProperty("airline_name")
    private String airline_name;

    @ApiModelProperty("航空公司 id")
    @JsonProperty("airline_id")
    private String airline_id;

    @ApiModelProperty("修改起飞时间")
    @JsonProperty("alter_take_off")
    private int alter_take_off;

    @ApiModelProperty("航班班次主键")
    @JsonProperty("flight_key")
    private String flight_key;

    @ApiModelProperty("值机计划结束时间")
    @JsonProperty("ck_plan_end_time")
    private int ck_plan_end_time;

    @ApiModelProperty("值机计划开放时间")
    @JsonProperty("ck_plan_open_time")
    private int ck_plan_open_time;

    @ApiModelProperty("值机实际结束时间")
    @JsonProperty("ck_real_end_time")
    private int ck_real_end_time;

    @ApiModelProperty("值机实际开放时间")
    @JsonProperty("ck_real_open_time")
    private int ck_real_open_time;

    @ApiModelProperty("航班号")
    @JsonProperty("flight_no")
    private String flight_no;

    @ApiModelProperty("航班日期，yyyyMMdd")
    @JsonProperty("flight_date")
    private String flight_date;

    @ApiModelProperty("是否入港航班，true 是，false 否")
    @JsonProperty("is_arr_flight")
    private Boolean is_arr_flight;

    @ApiModelProperty("是否过期航班，true 是，false 否")
    @JsonProperty("is_history")
    private Boolean is_history;

    @ApiModelProperty("计划结束登机时间")
    @JsonProperty("plan_end_time")
    private int plan_end_time;

    @ApiModelProperty("计划登机口")
    @JsonProperty("plan_gate_name")
    private String plan_gate_name;

    @ApiModelProperty("计划开始登机时间")
    @JsonProperty("plan_open_time")
    private int plan_open_time;

    @ApiModelProperty("计划起飞时间")
    @JsonProperty("plan_take_off")
    private int plan_take_off;

    @ApiModelProperty("实际结束登机时间")
    @JsonProperty("real_end_time")
    private int real_end_time;

    @ApiModelProperty("实际登机口")
    @JsonProperty("real_gate_name")
    private String real_gate_name;

    @ApiModelProperty("实际开始登机时间")
    @JsonProperty("real_open_time")
    private int real_open_time;

    @ApiModelProperty("中文航线，城市用-连接")
    @JsonProperty("route_cn_list")
    private List<String> route_cn_list;

    @ApiModelProperty("英文航线，城市用-连接")
    @JsonProperty("route_en_list")
    private List<String> route_en_list;

    @ApiModelProperty("机场三字码，用-连接")
    @JsonProperty("route_code_list")
    private List<String> route_code_list;

    @ApiModelProperty("0: 未知；1：本站起飞；2：本站到达；3：开始登机；4：催促登机；5：登机口关闭（结束登机）；6：过站登机 7：延误；8：取消，9：前方起飞， 10：备降， 11：返航 ， 12：值机开始 ， 13： 值机截止")
    @JsonProperty("status")
    private int status;
    
    @ApiModelProperty("航班出口")
    @JsonProperty("exit_gate")
    private String exit_gate;

    @ApiModelProperty("计划降落时间")
    @JsonProperty("plan_landing_time")
    private int plan_landing_time;

    @ApiModelProperty("修改降落时间")
    @JsonProperty("alter_landing_time")
    private int alter_landing_time;

    @ApiModelProperty("实际降落时间")
    @JsonProperty("real_landing_time")
    private int real_landing_time;
    
    @ApiModelProperty("航站楼")
    @JsonProperty("terminal")
    private String terminal;
}
