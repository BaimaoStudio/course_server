package com.mxf.course.controller;

import com.mxf.course.config.BaseController;
import com.mxf.course.config.ScExtException;
import com.mxf.course.config.SchedulTask;
import com.mxf.course.dto.SquidDto;
import com.mxf.course.service.SquidService;
import com.mxf.course.util.CommandUtil;
import org.apache.ibatis.cache.decorators.ScheduledCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by baimao
 * Time:2021/5/18
 */

@Controller
@RequestMapping("/api/v1/squid")
public class SquidController extends BaseController {

    @Autowired
    SquidService squidService;

    @Autowired
    SchedulTask schedulTask;

    @RequestMapping("console")
    public @ResponseBody
    String console(@RequestParam("command") String command,
                   HttpServletRequest request) throws IOException {
        return toJson(CommandUtil.run2(command), request);
    }

    @RequestMapping("showLog")
    public @ResponseBody String showLog(@RequestParam("port")String port) throws IOException {
        CommandUtil.realtimeShowLog(port);
        return "success";
    }

    @RequestMapping("opera")
    public @ResponseBody String opera(@RequestParam("param")String param,
                                      @RequestParam("port")String port,
                                      HttpServletRequest request) throws IOException, ScExtException {
        switch (param){
            case "1":
                param = "squid -k shutdown";
                break;
            case "2":
                param = "squid -k reconfigure";
                break;
            case "3":
                param = "service squid start";
                break;
            default:
                throw new ScExtException("操作命令错误");
        }
        String result = CommandUtil.run2("ssh localhost -p "+ port + param);
        return toJson(result,request);
    }

    @RequestMapping("mgr")
    public @ResponseBody
    String mgr(@RequestParam("port")String port, HttpServletRequest request) throws IOException {
        String result = CommandUtil.run2("ssh localhost -p "+ port +" squidclient -p 3888  mgr:info ");
        String[] strs = result.split("\n");
        StringBuilder connectionInfo = new StringBuilder();

        StringBuilder cacheInfo = new StringBuilder();

        StringBuilder mediaService  = new StringBuilder();

        StringBuilder resouceUsage = new StringBuilder();

        StringBuilder memoryAccount = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            if (i >= 20 && i <= 30) {
                connectionInfo.append("\n</br>").append(strs[i]);
            }
            if (i >= 32 && i <= 41) {
                cacheInfo.append("\n</br>").append(strs[i]);
            }
            if (i >= 42 && i <= 49) {
                mediaService.append("\n</br>").append(strs[i]);
            }
            if (i >= 50 && i <= 57) {
                resouceUsage.append("\n</br>").append(strs[i]);
            }
            if (i >= 58 && i <= 61) {
                memoryAccount.append("\n</br>").append(strs[i]);
            }
        }
        return toJson(new SquidDto(connectionInfo.toString(),cacheInfo.toString(),mediaService.toString(),resouceUsage.toString(),memoryAccount.toString()),request);
    }

    @RequestMapping("insertSquid")
    public @ResponseBody String insertSquid(@RequestParam("ip")String ip,
                                            @RequestParam("port")int port,
                                            HttpServletRequest request) throws ScExtException {
        return toJson(squidService.insertSquid(ip,port),request);
    }

    @RequestMapping("updateSquid")
    public @ResponseBody String updateSquid(@RequestParam("port")int port,
                                            @RequestParam("status")int status,
                                            HttpServletRequest request)throws ScExtException{
        return toJson(squidService.updateSquid(port,status),request);
    }

    @RequestMapping("testSquidOpera")
    public @ResponseBody String testSquidOpera(HttpServletRequest request) throws ScExtException {
        schedulTask.testTask();
        return toJson("success",request);
    }

    @RequestMapping("selectSquidByConditions")
    public @ResponseBody String selectSquidByConditions(@RequestParam("currentPage")int currentPage,
                                                        @RequestParam("pageSize")int pageSize,
                                                        @RequestParam(value = "ip",required = false)String ip,
                                                        @RequestParam(value = "port",required = false)String port,
                                                        @RequestParam(value = "name",required = false)String name,
                                                        HttpServletRequest request){
        return toJson(squidService.selectSquidByConditions(currentPage,pageSize,ip,port,name),request);
    }
}
