package com.mxf.course.controller;

import com.mxf.course.config.BaseController;
import com.mxf.course.config.ScExtException;
import com.mxf.course.entity.GradeEntity;
import com.mxf.course.service.GradeService;
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

    @RequestMapping("insertGrade")
    public @ResponseBody String insertGrade(@RequestBody GradeEntity gradeEntity,
                                             HttpServletRequest request) throws ScExtException {
        return toJson(gradeService.insertGrade(gradeEntity),request);
    }

    @RequestMapping("updateGrade")
    public @ResponseBody String updateGrade(@RequestBody GradeEntity gradeEntity,
                                             HttpServletRequest request) throws ScExtException {
        return toJson(gradeService.updateGrade(gradeEntity),request);
    }
    @RequestMapping("deleteGrade")
    public @ResponseBody String deleteGrade(@RequestParam("id")int id,
                                            HttpServletRequest request) throws ScExtException {
        return toJson(gradeService.deleteGrade(id),request);
    }

    @RequestMapping("selectGradesBySchoolId")
    public @ResponseBody String selectGradesBySchoolId(@RequestParam("id")int id,
                                                       HttpServletRequest request){
        return toJson(gradeService.selectGradesBySchoolId(id),request);
    }

    @RequestMapping("selectGradeDetailById")
    public @ResponseBody String selectGradeDetailById(@RequestParam("id")int id,
                                                      HttpServletRequest request){
        return toJson(gradeService.selectGradeDetail(id),request);
    }

    @RequestMapping("pageSelectGradesBySchoolId")
    public @ResponseBody String pageSelectGradesBySchoolId(@RequestParam("id")int id,
                                                          @RequestParam("currentPage")int currentPage,
                                                          @RequestParam("pageSize")int pageSize,
                                                          HttpServletRequest request){
        return toJson(gradeService.pageSelectGradesBySchoolId(currentPage,pageSize,id),request);
    }
}
