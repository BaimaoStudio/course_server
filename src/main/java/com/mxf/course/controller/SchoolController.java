package com.mxf.course.controller;

import com.mxf.course.config.BaseController;
import com.mxf.course.service.SchoolService;
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
@RequestMapping("/api/v1/school")
public class SchoolController extends BaseController {

    @Autowired
    SchoolService schoolService;

    @RequestMapping("selectSchoolEntityByConditions")
    public @ResponseBody String selectSchoolEntityByConditions(@RequestParam("currentPage")int currentPage,
                                                               @RequestParam("pageSize")int pageSize,
                                                               @RequestParam(value = "schoolname",required = false)String schoolname,
                                                               @RequestParam(value = "sketch",required = false)String sketch,
                                                               @RequestParam(value = "province",required = false)String province,
                                                               @RequestParam(value = "city",required = false)String city,
                                                               @RequestParam(value = "district",required = false)String district,
                                                               HttpServletRequest request){
        return toJson(schoolService.selectSchoolEntityByConditions(currentPage, pageSize, schoolname, sketch, province, city, district),request);
    }
}
