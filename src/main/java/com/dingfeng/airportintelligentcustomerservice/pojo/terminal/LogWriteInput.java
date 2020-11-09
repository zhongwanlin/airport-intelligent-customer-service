package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogWriteInput {

    /*
     * 模块ID：1摄像头，2语⾳转⽂字，3机票识别，4身份证识别器，5⽂字转语⾳
     */
    @JsonProperty("mac_model_id")
    private String macModelId;

    /*
     * 接⼝名称
     */
    @JsonProperty("sdk_name")
    private String sdkName;

    /* 接⼝版本 */
    @JsonProperty("versions")
    private String versions;

    /* 调⽤状态:1成功2失败 */
    @JsonProperty("run_status")
    private int runStatus;

    /* 调⽤状态:1成功2失败 */
    @JsonProperty("info")
    private String info;
}
