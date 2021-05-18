package com.mxf.course.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxf.course.dao.CourseMapper;
import com.mxf.course.entity.CourseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Service
public class CourseService {

    @Resource
    CourseMapper courseMapper;

    public PageInfo selectCourseByConditions(int currentPage,int pageSize,String coursename,String sketch){
        PageHelper.startPage(currentPage,pageSize);
        List<CourseEntity> list = courseMapper.selectCourseByConditions(coursename, sketch);
        PageInfo pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
