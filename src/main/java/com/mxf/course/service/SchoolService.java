package com.mxf.course.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxf.course.dao.SchoolMapper;
import com.mxf.course.entity.SchoolEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Service
public class SchoolService {

    @Resource
    SchoolMapper schoolMapper;

    public PageInfo selectSchoolEntityByConditions(int currentPage, int pageSize, String schoolname, String sketch, String province, String city, String district) {
        PageHelper.startPage(currentPage,pageSize);
        List<SchoolEntity> schoolEntityList = schoolMapper.selectSchoolEntityByConditions(schoolname, sketch, province, city, district);
        System.out.println(schoolEntityList.toString());
        PageInfo pageInfo =new PageInfo<>(schoolEntityList);
        return pageInfo;
    }
}
