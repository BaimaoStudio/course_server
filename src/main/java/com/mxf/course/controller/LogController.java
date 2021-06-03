package com.mxf.course.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxf.course.config.BaseController;
import com.mxf.course.dao.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by baimao
 * Time:2021/5/28
 */

@RequestMapping("/api/v1/log")
@Controller
public class LogController extends BaseController {

    @Resource
    LogMapper logMapper;

    @RequestMapping("selectAllLogs")
    public @ResponseBody String selectAllLogs(@RequestParam("currentPage")int currentPage,
                                              @RequestParam("pageSize")int pageSize,
                                              HttpServletRequest request){
        PageHelper.startPage(currentPage,pageSize);
        return toJson(new PageInfo<>(logMapper.selectAll()),request);
    }
}
