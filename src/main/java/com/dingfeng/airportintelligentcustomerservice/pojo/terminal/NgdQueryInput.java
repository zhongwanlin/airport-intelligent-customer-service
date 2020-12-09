package com.dingfeng.airportintelligentcustomerservice.pojo.terminal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NgdQueryInput {
    
    private String queryText;

    private String sessionId;

    private int flag;
}
