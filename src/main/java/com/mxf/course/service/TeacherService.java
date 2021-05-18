package com.mxf.course.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxf.course.dao.TeacherMapper;
import com.mxf.course.entity.TeacherEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Service
public class TeacherService {

    @Resource
    TeacherMapper teacherMapper;

    public PageInfo selectTeacherByConditions(int currentPage,int pageSize,String teachername){
        PageHelper.startPage(currentPage,pageSize);
        List<TeacherEntity> list = teacherMapper.selectTeacherByConditions(teachername);
        PageInfo pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
