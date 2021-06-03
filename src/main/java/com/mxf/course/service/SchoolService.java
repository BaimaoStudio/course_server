package com.mxf.course.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxf.course.config.ScExtException;
import com.mxf.course.dao.SchoolMapper;
import com.mxf.course.entity.SchoolEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public List<SchoolEntity> selectAllSchool(){
        List<SchoolEntity> schoolEntityList = new ArrayList<>();
        schoolEntityList = schoolMapper.selectAll();
        System.out.println(schoolEntityList.toString());
        return schoolEntityList;
    }

    public String insertSchool(SchoolEntity schoolEntity) throws ScExtException {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String d = simpleDateFormat.format(date).replace("-","");
        System.out.println(d);
        schoolEntity.setCreatdate(Integer.parseInt(d));
        if (schoolMapper.insertSelective(schoolEntity)<0){
            throw new ScExtException("添加学校失败");
        }
        return "success";
    }
    public String updateSchool(SchoolEntity schoolEntity) throws ScExtException {
        if (schoolMapper.updateByPrimaryKeySelective(schoolEntity)<0){
            throw new ScExtException("修改学校失败");
        }
        return "success";
    }

    public SchoolEntity selectOneSchool(int id){
        return schoolMapper.selectByPrimaryKey(id);
    }

    public String deleteSchool(int id) throws ScExtException {
        if (schoolMapper.deleteByPrimaryKey(id)<0){
            throw new ScExtException("删除学校失败");
        }
        return "success";
    }

}
