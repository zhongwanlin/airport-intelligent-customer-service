package com.dingfeng.airportintelligentcustomerservice.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingfeng.airportintelligentcustomerservice.config.ApiUrlConfig;
import com.dingfeng.airportintelligentcustomerservice.core.ExceptionUtil;
import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.terminal.*;
import com.dingfeng.airportintelligentcustomerservice.service.MachineService;
import com.dingfeng.airportintelligentcustomerservice.service.TerminalApiService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/*
* Api 接口
*/
@Api(value = "/terminal", description = "终端对接Api 接口")
@RestController
public class TerminalApiController {

    @Autowired
    TerminalApiService terminalApiService;

    @Autowired
    MachineService machineService;

    @Autowired
    private ApiUrlConfig apiUrlConfig;

    @Autowired
    private RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(TerminalApiController.class);

    /**
     * 
     * @return
     */
    @ApiOperation(value = "终端-调⽤模块记录", notes = "")
    @ApiParam
    @PostMapping(value = "api/log/write")
    @ResponseBody
    public Result logWrite(@RequestBody LogWriteInput input, @RequestHeader HttpHeaders headers) {
        List<String> gomsTokens = headers.get("gomstoken");
        if (gomsTokens == null || gomsTokens.size() == 0) {
            return Result.Error("未携带机器码");
        }

        input.setMac_id(gomsTokens.get(0));

        return machineService.addMachineSdkLog(input);
    }

    /**
     *
     * @return
     */
    @ApiOperation(value = "终端-⼼跳", notes = "")
    @ApiParam
    @PostMapping(value = "api/heart_beat")
    @ResponseBody
    public Result heartBeat(@RequestBody HeartBeatInput input, @RequestHeader HttpHeaders headers) {
        List<String> gomsTokens = headers.get("gomstoken");
        if (gomsTokens == null || gomsTokens.size() == 0) {
            return Result.Error("未携带机器码");
        }

        input.setMac_id(gomsTokens.get(0));
        input.setBody(JSONObject.toJSON(input).toString());

        return machineService.addMachineRunLog(input);
    }

    // /**
    // *
    // * @return
    // */
    // @ApiOperation(value = "终端-版本检查", notes = "")
    // @ApiParam
    // @PostMapping(value = "api/terminal/checkVersion")
    // @ResponseBody
    // public Result checkHeartBeatVersion(@RequestBody CheckHeartBeatVersionInput
    // version,
    // @RequestHeader HttpHeaders headers) {
    // Result result = new Result();

    // result.setData(new Version());

    // return result;
    // }

    /**
     *
     * @return
     */
    @ApiOperation(value = "web-语音文字处理", notes = "")
    @ApiParam
    @PostMapping(value = "/api/terminal/voice")
    @ResponseBody
    public Result voice(@RequestBody VoiceInput voice, @RequestHeader HttpHeaders headers) {

        logger.info("web-语音文字处理,/api/terminal/voice," + JSON.toJSONString(voice));

        List<String> gomsTokens = headers.get("gomstoken");
        if (gomsTokens == null || gomsTokens.size() == 0) {
            return Result.Error("未携带机器码");
        }
        String content = voice.getContent();
        if (content == null || content == "") {
            return Result.Error("非常抱歉，我没听懂您说什么，麻烦您再说一遍好吗？");
        }
        content = content.replace(",", "").replaceAll("。", "");
        Result result = new Result();
        try {
            String rex = "(^[A-Z\\d]{2}\\d{3,4}|[a-zA-Z][a-zA-Z0-9]{1,5}|^\\d{3,4}$)";
            Pattern pattern = Pattern.compile(rex);
            Matcher matcher = pattern.matcher(content);
            String flightNo = "";
            String apiURL = apiUrlConfig.getFlightQueryApi();
            FlightSearchResult flightResult = null;
            while (matcher.find()) {
                int count = matcher.groupCount();
                for (int i = 1; i <= count; i++) {
                    flightNo = matcher.group(i);
                    String requestUrl = apiURL + flightNo;
                    FlightSearchResult flightSearchResult = restTemplate.getForObject(requestUrl,
                            FlightSearchResult.class);
                    logger.info(requestUrl + "请求结果：" + JSON.toJSONString(flightSearchResult));
                    if (flightSearchResult != null && flightSearchResult.getError_no() == 0) {
                        if (flightResult == null) {
                            flightResult = new FlightSearchResult();
                            flightResult.setError_no(0);
                            flightResult.setData(flightSearchResult.getData());
                        } else {
                            flightResult.getData().addAll(flightSearchResult.getData());
                        }
                    }
                }
            }
            if (flightResult == null) {
                result.setCode("99");
                result.setMsg("非常抱歉，没找到您的航班信息或者您可以直接说：HU078");
            } else {
                result.setCode("0");
                result.setMsg("SUCCESS");
                result.setData(flightResult);
            }
        } catch (Exception e) {
            logger.error("web-语音文字处理异常" + ExceptionUtil.getExceptionSrintStackTrace(e));
            result.setCode("99");
            result.setMsg("非常抱歉，小美遇到了麻烦，正在努力处理，请您稍等...");
        }

        return result;
    }

    // /**
    // *
    // * @return
    // */
    // @ApiOperation(value = "终端-语⾳识别", notes = "")
    // @ApiParam
    // @GetMapping(value = "/api/terminal/voice/get")
    // @ResponseBody
    // public Result vr() {
    // Result result = new Result();

    // result.setCode("0");
    // result.setMsg("SUCCESS");
    // result.setData(new VrOutput());

    // return result;
    // }

    // /**
    // *
    // * @return
    // */
    // @ApiOperation(value = "web-机场服务-内容获取", notes = "")
    // @ApiParam
    // @PostMapping(value = "api/web/article/get")
    // @ResponseBody
    // public Result airportServiceArticle(@RequestBody AirportServiceArticleInput
    // article,
    // @RequestHeader HttpHeaders headers) {
    // Result result = new Result();

    // result.setData(new AirportServiceArticleOutput());

    // return result;
    // }

    // /**
    // *
    // * @return
    // */
    // @ApiOperation(value = "web-机场服务-内容列表获取", notes = "")
    // @ApiParam
    // @PostMapping(value = "api/web/article/list")
    // @ResponseBody
    // public Result airportServiceArticleList(@RequestBody
    // AirportServiceArticleInput article,
    // @RequestHeader HttpHeaders headers) {
    // Result result = new Result();

    // result.setData(new ArrayList<AirportServiceArticleOutput>());

    // return result;
    // }

    // /**
    // *
    // * @return
    // */
    // @ApiOperation(value = "web-反馈", notes = "")
    // @ApiParam
    // @PostMapping(value = "api/web/comment")
    // @ResponseBody
    // public Result comment(@RequestBody CommentInput comment, @RequestHeader
    // HttpHeaders headers) {
    // Result result = new Result();

    // result.setCode("0");
    // result.setMsg("SUCCESS");

    // return result;
    // }

    // /**
    // *
    // * @return
    // */
    // @ApiOperation(value = "web-机场服务-栏⽬获取", notes = "")
    // @ApiParam
    // @PostMapping(value = "api/web/asp/list")
    // @ResponseBody
    // public Result asp(@RequestBody AspInput asp, @RequestHeader HttpHeaders
    // headers) {
    // Result result = new Result();

    // result.setCode("0");
    // result.setMsg("SUCCESS");
    // result.setData(new ArrayList<AspOutput>());

    // return result;
    // }

    // /**
    // *
    // * @return
    // */
    // @ApiOperation(value = "web-获取导航图", notes = "")
    // @ApiParam
    // @GetMapping(value = "api/web/map/get")
    // @ResponseBody
    // public Result map() {
    // Result result = new Result();

    // result.setCode("0");
    // result.setMsg("SUCCESS");
    // result.setData(new MapOutput());

    // return result;
    // }

    // /**
    // *
    // * @return
    // */
    // @ApiOperation(value = "web-⼈脸识别", notes = "")
    // @ApiParam
    // @PostMapping(value = "/api/web/face/get")
    // @ResponseBody
    // public Result searchFace(@RequestBody FaceSearchInput searchFace,
    // @RequestHeader HttpHeaders headers) {
    // Result result = new Result();

    // FaceSearchOutput face = terminalApiService.getFace(76);

    // result.setCode("0");
    // result.setMsg("SUCCESS");
    // result.setData(face);

    // return result;
    // }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "航班查询", notes = "")
    @ApiParam
    @GetMapping(value = "/api/flight/search/{flightNo}")
    @ResponseBody
    public FlightSearchResult flightSearch(@PathVariable("flightNo") String flightNo,
            @RequestHeader HttpHeaders headers) {
        return terminalApiService.getFlight(flightNo);
    }

    // /**
    // *
    // * @return
    // */
    // @ApiOperation(value = "航班查询测试", notes = "")
    // @ApiParam
    // @GetMapping(value = "/api/flight/search/test")
    // @ResponseBody
    // public FlightSearchResult flightSearchTest(@RequestParam("flightNo") String
    // flightNo,
    // @RequestHeader HttpHeaders headers) {
    // String apiURL = apiUrlConfig.getFlightQueryApi() + "?flightNo=" + flightNo;
    // FlightSearchResult flightSearchResult = restTemplate.getForObject(apiURL,
    // FlightSearchResult.class);

    // return flightSearchResult;
    // }

}
