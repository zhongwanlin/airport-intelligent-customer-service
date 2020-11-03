package com.dingfeng.airportintelligentcustomerservice.controller.api;

import java.util.ArrayList;

import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.pojo.terminal.*;
import com.dingfeng.airportintelligentcustomerservice.service.TerminalApiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 
     * @return
     */
    @ApiOperation(value = "终端-调⽤模块记录", notes = "")
    @ApiParam
    @PostMapping(value = "api/log/write")
    @ResponseBody
    public Result logWrite(@RequestBody LogWriteInput logWriteInfo) {
        return new Result();
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "终端-⼼跳", notes = "")
    @ApiParam
    @PostMapping(value = "api/heart_beat")
    @ResponseBody
    public Result heartBeat(@RequestBody HeartBeatInput heartBeatInput) {
        Result result = new Result();

        result.setData(new HeartBeatOutput());

        return result;
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "终端-版本检查", notes = "")
    @ApiParam
    @PostMapping(value = "api/heart_beat/checkVersion")
    @ResponseBody
    public Result checkHeartBeatVersion(@RequestBody CheckHeartBeatVersionInput version) {
        Result result = new Result();

        result.setData(new Version());

        return result;
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "web-机场服务-内容获取", notes = "")
    @ApiParam
    @PostMapping(value = "api/Airport_Service/article")
    @ResponseBody
    public Result airportServiceArticle(@RequestBody AirportServiceArticleInput article) {
        Result result = new Result();

        result.setData(new AirportServiceArticleOutput());

        return result;
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "web-机场服务-内容列表获取", notes = "")
    @ApiParam
    @PostMapping(value = "api/Airport_Service/articleList")
    @ResponseBody
    public Result airportServiceArticleList(@RequestBody AirportServiceArticleInput article) {
        Result result = new Result();

        result.setData(new ArrayList<AirportServiceArticleOutput>());

        return result;
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "web-反馈", notes = "")
    @ApiParam
    @PostMapping(value = "api/Comment")
    @ResponseBody
    public Result comment(@RequestBody CommentInput comment) {
        Result result = new Result();

        result.setCode("0");
        result.setMsg("SUCCESS");

        return result;
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "web-机场服务-栏⽬获取", notes = "")
    @ApiParam
    @PostMapping(value = "api/Asp")
    @ResponseBody
    public Result asp(@RequestBody AspInput asp) {
        Result result = new Result();

        result.setCode("0");
        result.setMsg("SUCCESS");
        result.setData(new ArrayList<AspOutput>());

        return result;
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "web-获取导航图", notes = "")
    @ApiParam
    @GetMapping(value = "api/Map")
    @ResponseBody
    public Result map() {
        Result result = new Result();

        result.setCode("0");
        result.setMsg("SUCCESS");
        result.setData(new MapOutput());

        return result;
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "web-⼈脸识别", notes = "")
    @ApiParam
    @PostMapping(value = "/api/Face/search")
    @ResponseBody
    public Result searchFace(@RequestBody FaceSearchInput searchFace) {
        Result result = new Result();

        FaceSearchOutput face = terminalApiService.getFace(76);

        result.setCode("0");
        result.setMsg("SUCCESS");
        result.setData(face);

        return result;
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "终端-语⾳识别", notes = "")
    @ApiParam
    @PostMapping(value = "/api/voice")
    @ResponseBody
    public Result voice(@RequestBody VoiceInput voice) {
        Result result = new Result();

        result.setCode("0");
        result.setMsg("SUCCESS");
        result.setData(new VoiceOutput());

        return result;
    }

    /**
     * 
     * @return
     */
    @ApiOperation(value = "终端-语⾳识别", notes = "")
    @ApiParam
    @GetMapping(value = "/api/vr")
    @ResponseBody
    public Result vr() {
        Result result = new Result();

        result.setCode("0");
        result.setMsg("SUCCESS");
        result.setData(new VrOutput());

        return result;
    }

     /**
     * 
     * @return
     */
    @ApiOperation(value = "航班查询", notes = "")
    @ApiParam
    @GetMapping(value = "/api/flight/search")
    @ResponseBody
    public Result flightSearch(@RequestParam("flightNo") String flightNo) {
        Result result = new Result();

        result.setCode("0");
        result.setMsg("SUCCESS");
        result.setData(new FlightSearchResult());

        return result;
    }

}
