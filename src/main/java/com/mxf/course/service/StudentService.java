//package com.mxf.course.service;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.mxf.course.dao.StudentMapper;
//import com.mxf.course.entity.StudentEntity;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * Created by baimao
// * Time:2021/5/17
// */
//
//@Service
//public class StudentService {
//
//    @Resource
//    StudentMapper studentMapper;
//
//    public PageInfo selectStudentsByConditions(int currentPage,int pageSize,String nickname,String username){
//        PageHelper.startPage(currentPage,pageSize);
//        List<StudentEntity> list = studentMapper.selectStudentsByConditions(nickname, username);
//        PageInfo pageInfo = new PageInfo<>(list);
//        return pageInfo;
//    }
//}
