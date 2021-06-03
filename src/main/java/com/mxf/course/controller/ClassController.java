package com.mxf.course.controller;

import com.mxf.course.config.BaseController;
import com.mxf.course.config.ScExtException;
import com.mxf.course.entity.ClassEntity;
import com.mxf.course.service.ClassService;
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


    @RequestMapping("insertClass")
    public @ResponseBody String insertClass(@RequestBody ClassEntity classEntity,
                                            HttpServletRequest request) throws ScExtException {
        return toJson(classService.insertClass(classEntity),request);
    }

    @RequestMapping("updateClass")
    public @ResponseBody String updateClass(@RequestBody ClassEntity classEntity,
                                            HttpServletRequest request) throws ScExtException {
        return toJson(classService.updateClass(classEntity),request);
    }


    @RequestMapping("deleteClass")
    public @ResponseBody String deleteClass(@RequestParam("id")int id,
                                            HttpServletRequest request) throws ScExtException {
        return toJson(classService.deleteClass(id),request);
    }

    @RequestMapping("selectClassBySchoolId")
    public @ResponseBody String selectClassBySchoolId(@RequestParam("id")int id,
                                                      HttpServletRequest request){
        return toJson(classService.selectClassBySchoolId(id),request);
    }

    @RequestMapping("selectClassByGradeId")
    public @ResponseBody String selectClassByGradeId(@RequestParam("id")int id,
                                                     HttpServletRequest request){
        return toJson(classService.selectClassByGradeId(id),request);
    }
    @RequestMapping("pageSelectClassByGradeId")
    public @ResponseBody String pageSelectClassByGradeId(@RequestParam("id")int id,
                                                          @RequestParam("currentPage")int currentPage,
                                                          @RequestParam("pageSize")int pageSize,
                                                          HttpServletRequest request){
        return toJson(classService.pageSelectClassByGradeId(currentPage,pageSize,id),request);
    }

    @RequestMapping("selectClassDetail")
    public @ResponseBody String selectClassDetail(@RequestParam("id")int id,
                                                  HttpServletRequest request){
        return toJson(classService.selectClassDetail(id),request);
    }
}
