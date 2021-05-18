package com.mxf.course.controller;

import com.mxf.course.config.BaseController;
import com.mxf.course.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Controller
@RequestMapping("/api/v1/class")
public class ClassController extends BaseController {

    @Autowired
    ClassService classService;

    @RequestMapping("selectClassByConditions")
    public @ResponseBody String selectClassByConditions(@RequestParam("currentPage")int currentPage,
                                                        @RequestParam("pageSize")int pageSize,
                                                        @RequestParam(value = "classname",required = false)String classname,
                                                        @RequestParam(value = "sketch",required = false)String sketch,
                                                        HttpServletRequest request){
        return toJson(classService.selectClassByConditions(currentPage, pageSize, classname, sketch),request);
    }
}
