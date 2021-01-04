package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NgdData {
    private String suggestAnswer;
    private NgdContext context ;
    private List<String> actions;
}
