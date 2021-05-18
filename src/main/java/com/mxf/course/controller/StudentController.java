//package com.mxf.course.controller;
//
//import com.mxf.course.config.BaseController;
//import com.mxf.course.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by baimao
// * Time:2021/5/17
// */
//
//@Controller
//@RequestMapping("/api/v1/student")
//public class StudentController extends BaseController {
//
//    @Autowired
//    StudentService studentService;
//
//    @RequestMapping("selectStudentsByConditions")
//    public @ResponseBody String selectStudentsByConditions(@RequestParam("currentPage") int currentPage,
//                                                           @RequestParam("pageSize")int pageSize,
//                                                           @RequestParam(value = "nickname",required = false) String nickname,
//                                                           @RequestParam(value = "username",required = false)String username,
//                                                           HttpServletRequest request){
//        return toJson(studentService.selectStudentsByConditions(currentPage, pageSize, nickname, username),request);
//    }
//}
