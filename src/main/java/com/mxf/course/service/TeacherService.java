package com.mxf.course.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxf.course.config.ScExtException;
import com.mxf.course.dao.TeacherMapper;
import com.mxf.course.entity.CourseEntity;
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

    public String insertTeacher(TeacherEntity teacherEntity) throws ScExtException {
        if (teacherMapper.insertSelective(teacherEntity)<0){
            throw new ScExtException("添加老师失败");
        }
        return "success";
    }
    public String updateTeacher(TeacherEntity teacherEntity) throws ScExtException {
        if (teacherMapper.updateByPrimaryKeySelective(teacherEntity)<0){
            throw new ScExtException("修改老师失败");
        }
        return "success";
    }

    public String deleteTeacher(int id) throws ScExtException {
        if (teacherMapper.deleteByPrimaryKey(id)<0){
            throw new ScExtException("删除老师失败");
        }
        return "success";
    }
}
