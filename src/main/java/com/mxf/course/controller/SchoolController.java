package com.mxf.course.controller;

import com.mxf.course.config.BaseController;
import com.mxf.course.config.ScExtException;
import com.mxf.course.entity.SchoolEntity;
import com.mxf.course.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("selectAllSchool")
    public @ResponseBody String selectAllSchool(HttpServletRequest request){
        return toJson(schoolService.selectAllSchool(),request);
    }

    @RequestMapping("insertSchool")
    public @ResponseBody String insertSchool(@RequestBody SchoolEntity schoolEntity,
                                             HttpServletRequest request) throws ScExtException {
        return toJson(schoolService.insertSchool(schoolEntity),request);
    }

    @RequestMapping("updateSchool")
    public @ResponseBody String updateSchool(@RequestBody SchoolEntity schoolEntity,
                                             HttpServletRequest request) throws ScExtException {
        return toJson(schoolService.updateSchool(schoolEntity),request);
    }

    @RequestMapping("selectSchoolById")
    public @ResponseBody String selectSchoolById(@RequestParam("id")int id,
                                                 HttpServletRequest request){
        return toJson(schoolService.selectOneSchool(id),request);
    }
    @RequestMapping("deleteSchool")
    public @ResponseBody String deleteSchool(@RequestParam("id")int id,
                                             HttpServletRequest request) throws ScExtException {
        return toJson(schoolService.deleteSchool(id),request);
    }

}
