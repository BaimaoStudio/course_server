package com.mxf.course.controller;

import com.mxf.course.config.BaseController;
import com.mxf.course.service.GradeService;
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
@RequestMapping("/api/v1/grade")
public class GradeController extends BaseController {

    @Autowired
    GradeService gradeService;

    @RequestMapping("/selectGradeByConditions")
    public @ResponseBody String selectGradeByConditions(@RequestParam("currentPage")int currentPage,
                                                        @RequestParam("pageSize")int pageSize,
                                                        @RequestParam(value = "gradename",required = false)String gradename,
                                                        @RequestParam(value = "year",required = false)String year,
                                                        HttpServletRequest request){
        return toJson(gradeService.selectGradeByConditions(currentPage, pageSize, gradename, year),request);
    }
}
