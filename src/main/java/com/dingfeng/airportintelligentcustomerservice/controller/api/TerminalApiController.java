package com.dingfeng.airportintelligentcustomerservice.controller.api;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingfeng.airportintelligentcustomerservice.config.ApiUrlConfig;
import com.dingfeng.airportintelligentcustomerservice.core.BaiduNgdResult;
import com.dingfeng.airportintelligentcustomerservice.core.ExceptionUtil;
import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.core.Unity;
import com.dingfeng.airportintelligentcustomerservice.pojo.PekApp.FltPlaceCondResult;
import com.dingfeng.airportintelligentcustomerservice.pojo.PekApp.FtNoCondNewResult;
import com.dingfeng.airportintelligentcustomerservice.pojo.PekApp.PekFlightDetailResult;
import com.dingfeng.airportintelligentcustomerservice.pojo.PekApp.ThreeCode;
import com.dingfeng.airportintelligentcustomerservice.pojo.terminal.*;
import com.dingfeng.airportintelligentcustomerservice.service.MachineService;
import com.dingfeng.airportintelligentcustomerservice.service.TerminalApiService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
    @PostMapping(value = "/api/log/write")
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
    @PostMapping(value = "/api/heart_beat")
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
    public Object voice(@RequestBody VoiceInput voice, @RequestHeader HttpHeaders headers) {

        logger.info("path: /api/terminal/voice," + "header:" + JSON.toJSONString(headers) + ",Body："
                + JSON.toJSONString(voice));

        List<String> gomsTokens = headers.get("gomstoken");
        if (gomsTokens == null || gomsTokens.size() == 0) {
            return Result.Error("未携带机器码");
        }
        Result result = new Result();
        try {
            HttpHeaders eripHeader = new HttpHeaders();
            eripHeader.add("erip-action", "query");
            eripHeader.add("erip-target", "baiDuNgdAnswerInfo");
            eripHeader.setContentType(MediaType.APPLICATION_JSON);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("queryText", voice.getContent());
            jsonObject.put("sessionId", voice.getSessionId());
            jsonObject.put("flag", voice.getFlag());

            String apiURL = apiUrlConfig.getFlightQueryApi();

            HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject, eripHeader);

            logger.info(apiURL + " 请求：" + JSON.toJSONString(entity));

            BaiduNgdResult baiduNgdResult = restTemplate.postForObject(apiURL, entity, BaiduNgdResult.class);

            logger.info(apiURL + " 请求结果：" + JSON.toJSONString(baiduNgdResult));

            return baiduNgdResult;

        } catch (Exception e) {
            logger.error("web-语音文字处理异常" + ExceptionUtil.getExceptionSrintStackTrace(e));
            result.setCode("99");
            result.setMsg("非常抱歉，我遇到了点小麻烦，正在努力处理，请您稍等...");
        }

        return result;
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "模拟航班查询", notes = "")
    @ApiParam
    @PostMapping(value = "/api/erip/query")
    @ResponseBody
    public Object ngdQuery(@RequestBody NgdQueryInput ngdQueryInput, @RequestHeader HttpHeaders headers) {

        NgdResult result = new NgdResult();
        result.setCode("200");
        result.setMsg("ok");

        NgdData ngdData = new NgdData();
        ngdData.setSuggestAnswer("测试航班数据");

        try {

            if (ngdQueryInput.getFlag() == 0) {
                ClassPathResource classPathResource = new ClassPathResource("mock/fltNoCondNew.json");
                InputStream inputStream = classPathResource.getInputStream();

                String answer = Unity.readJsonFile(inputStream);
                JSONObject jsonobject = JSONObject.parseObject(answer);
                FtNoCondNewResult flightResult = jsonobject.toJavaObject(FtNoCondNewResult.class);
                ngdData.setAnswer(flightResult);
            } else {
                ClassPathResource classPathResource = new ClassPathResource("mock/fltPlaceCond.json");
                InputStream inputStream = classPathResource.getInputStream();

                String answer = Unity.readJsonFile(inputStream);
                JSONObject jsonobject = JSONObject.parseObject(answer);
                FltPlaceCondResult flightResult = jsonobject.toJavaObject(FltPlaceCondResult.class);
                ngdData.setAnswer(flightResult);
            }

            result.setData(ngdData);
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }

        return result;
    }

    /**
     *
     * @return
     */
    @ApiOperation(value = "航班详情", notes = "")
    @ApiParam
    @PostMapping(value = "/api/terminal/flightDetail")
    @ResponseBody
    public Object flightDetail(@RequestBody FlightDetailQuery query, @RequestHeader HttpHeaders headers) {

        logger.info("path: /api/terminal/flightDetail," + "header:" + JSON.toJSONString(headers) + ",Body："
                + JSON.toJSONString(query));

        List<String> gomsTokens = headers.get("gomstoken");
        if (gomsTokens == null || gomsTokens.size() == 0) {
            return Result.Error("未携带机器码");
        }
        Result result = new Result();
        try {
            HttpHeaders eripHeader = new HttpHeaders();
            eripHeader.add("erip-action", "query");
            eripHeader.add("erip-target", "bciaFlightDetail");
            eripHeader.add("erip-source", "bcia");
            eripHeader.setContentType(MediaType.APPLICATION_JSON);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("fltId", query.getFltId());
            jsonObject.put("arrdep", query.getArrdep());
            jsonObject.put("source", "ROBOT_V2");

            String apiURL = apiUrlConfig.getYgFlightQuery();

            HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject, eripHeader);

            logger.info(apiURL + " 请求：" + JSON.toJSONString(entity));

            PekFlightDetailResult pekFlightDetailResult = restTemplate.postForObject(apiURL, entity,
                    PekFlightDetailResult.class);

            logger.info(apiURL + " 请求结果：" + JSON.toJSONString(pekFlightDetailResult));

            return pekFlightDetailResult;

        } catch (Exception e) {
            logger.error("web-语音文字处理异常" + ExceptionUtil.getExceptionSrintStackTrace(e));
            result.setCode("99");
            result.setMsg("非常抱歉，我遇到了点小麻烦，正在努力处理，请您稍等...");
        }

        return result;
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "模拟航班查询", notes = "")
    @ApiParam
    @PostMapping(value = "/api/erip/detailTest")
    @ResponseBody
    public Object eripDetailTest(@RequestBody FlightDetailQuery query, @RequestHeader HttpHeaders headers) {
        PekFlightDetailResult result = new PekFlightDetailResult();

        try {

            ClassPathResource classPathResource = new ClassPathResource("mock/flightDetail.json");
            InputStream inputStream = classPathResource.getInputStream();

            String answer = Unity.readJsonFile(inputStream);
            JSONObject jsonobject = JSONObject.parseObject(answer);
            result = jsonobject.toJavaObject(PekFlightDetailResult.class);

            return result;

        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("-1");
            result.setMsg(e.getMessage());
            return result;
        }
    }

    /**
     *
     * @return
     */
    @ApiOperation(value = "获取当天航班", notes = "")
    @ApiParam
    @PostMapping(value = "/api/terminal/getFlightDaily")
    @ResponseBody
    public Object getFlightDaily(@RequestHeader HttpHeaders headers) {

        logger.info("path: /api/erip/getFlightDaily," + "header:" + JSON.toJSONString(headers));

        List<String> gomsTokens = headers.get("gomstoken");
        if (gomsTokens == null || gomsTokens.size() == 0) {
            return Result.Error("未携带机器码");
        }

        try {

            ClassPathResource classPathResource = new ClassPathResource("mock/ThreeCode.json");
            InputStream inputStream = classPathResource.getInputStream();

            String answer = Unity.readJsonFile(inputStream);
            JSONObject jsonobject = JSONObject.parseObject(answer);
            ThreeCode threeCode = jsonobject.toJavaObject(ThreeCode.class);

            HttpHeaders eripHeader = new HttpHeaders();
            eripHeader.setContentType(MediaType.APPLICATION_JSON);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());
            System.out.println();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("pageNo", 1);
            jsonObject.put("arrdep", "A");
            jsonObject.put("queryDate", formatter.format(date));
            jsonObject.put("source", "ROBOT_V2");

            String apiURL = "http://10.40.13.211:8080/pek-app/flt/getByPlaceCond";

            List<String> codes = threeCode.getThreeCode();

            String path = "/home/zel/flights/" + formatter.format(date) + "/";

            List<PekFlightDetailResult> listPekFlightDetailResult = new ArrayList<PekFlightDetailResult>();
            for (String code : codes) {
                jsonObject.put("code", code);

                HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject, eripHeader);

                logger.info(apiURL + " 请求：" + JSON.toJSONString(entity));

                PekFlightDetailResult pekFlightDetailResult = restTemplate.postForObject(apiURL, entity,
                        PekFlightDetailResult.class);

                Unity.writeFile(path + code + "/" + formatter.format(date) + ".json",
                        JSON.toJSONString(pekFlightDetailResult));

                logger.info(apiURL + " 请求结果：" + JSON.toJSONString(pekFlightDetailResult));

                listPekFlightDetailResult.add(pekFlightDetailResult);
            }

            // 根据航班号获取
            if (listPekFlightDetailResult.size() > 0) {
                String apiUrl2 = "http://10.40.13.211:8080/pek-app/flt/getByFltNoCondNew";
                JSONObject jsonObject2 = new JSONObject();
                jsonObject.put("queryDate", formatter.format(date));
                jsonObject.put("source", "ROBOT_V2");
                for (PekFlightDetailResult pek : listPekFlightDetailResult) {
                    String fltNo = pek.getRst().getFltNo();
                    jsonObject.put("fltNo", fltNo);

                    HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject2, eripHeader);

                    logger.info(apiUrl2 + " 请求：" + JSON.toJSONString(entity));

                    FltPlaceCondResult fltPlaceCondResult = restTemplate.postForObject(apiUrl2, entity,
                            FltPlaceCondResult.class);

                    Unity.writeFile(path + fltNo + "/" + formatter.format(date) + ".json",
                            JSON.toJSONString(fltPlaceCondResult));

                    logger.info(apiURL + " 请求结果：" + JSON.toJSONString(fltPlaceCondResult));

                }
            }

            return Result.Success("ok");

        } catch (Exception e) {
            logger.error("web-获取当天航班处理异常" + ExceptionUtil.getExceptionSrintStackTrace(e));
            return Result.Error(e.getMessage());
        }
    }

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
    @ApiOperation(value = "模拟航班查询", notes = "")
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
