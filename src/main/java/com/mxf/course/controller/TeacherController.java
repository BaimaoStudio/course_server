package com.mxf.course.controller;

import com.mxf.course.config.BaseController;
import com.mxf.course.config.ScExtException;
import com.mxf.course.dao.TeacherMapper;
import com.mxf.course.entity.CourseEntity;
import com.mxf.course.entity.TeacherEntity;
import com.mxf.course.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("insertTeacher")
    public @ResponseBody String insertTeacher(@RequestBody TeacherEntity teacherEntity,
                                             HttpServletRequest request) throws ScExtException {
        return toJson(teacherService.insertTeacher(teacherEntity),request);
    }

    @RequestMapping("updateTeacher")
    public @ResponseBody String updateTeacher(@RequestBody TeacherEntity teacherEntity,
                                              HttpServletRequest request) throws ScExtException {
        return toJson(teacherService.updateTeacher(teacherEntity),request);
    }

    @RequestMapping("deleteTeacher")
    public @ResponseBody String deleteTeacher(@RequestParam("id")int id,
                                              HttpServletRequest request) throws ScExtException {
        return toJson(teacherService.deleteTeacher(id),request);
    }
}
