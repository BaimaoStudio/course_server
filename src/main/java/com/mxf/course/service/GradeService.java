package com.mxf.course.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxf.course.dao.GradeMapper;
import com.mxf.course.entity.GradeEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Service
public class GradeService {

    @Resource
    GradeMapper gradeMapper;

    public PageInfo selectGradeByConditions(int currentPage,int pageSize, String gradename, String year){
        PageHelper.startPage(currentPage,pageSize);
        List<GradeEntity> gradeEntityList = gradeMapper.selectGradeByConditions(gradename, year);
        PageInfo pageInfo = new PageInfo<>(gradeEntityList);
        return pageInfo;
    }
}
