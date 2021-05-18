package com.mxf.course.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxf.course.dao.ClassMapper;
import com.mxf.course.entity.ClassEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Service
public class ClassService {

    @Resource
    ClassMapper classMapper;

    public PageInfo selectClassByConditions(int currentPage,int pageSize,String classname,String sketch){
        PageHelper.startPage(currentPage,pageSize);
        List<ClassEntity> classEntityList = classMapper.selectClassByConditions(classname, sketch);
        PageInfo pageInfo = new PageInfo<>(classEntityList);
        return pageInfo;
    }
}
