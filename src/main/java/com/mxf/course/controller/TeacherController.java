package com.mxf.course.controller;

import com.mxf.course.config.BaseController;
import com.mxf.course.dao.TeacherMapper;
import com.mxf.course.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Controller
@RequestMapping("/api/v1/teacher")
public class TeacherController extends BaseController {

    @Resource
    TeacherService teacherService;

    @RequestMapping("selectTeacherByConditions")
    public @ResponseBody String selectTeacherByConditions(@RequestParam("currentPage")int currentPage,
                                                          @RequestParam("pageSize")int pageSize,
                                                          @RequestParam(value = "teachername",required = false)String teachername,
                                                          HttpServletRequest request){
        return toJson(teacherService.selectTeacherByConditions(currentPage, pageSize, teachername),request);
    }
}
