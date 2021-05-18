package com.mxf.course.controller;

import com.mxf.course.config.BaseController;
import com.mxf.course.util.CommandUtil;
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

    @RequestMapping("console")
    public @ResponseBody String console(@RequestParam("command")String command,
                                        HttpServletRequest request) throws IOException {
        return toJson(CommandUtil.run2(command),request);
    }

}
