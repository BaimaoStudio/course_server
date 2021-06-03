package com.mxf.course.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxf.course.config.ScExtException;
import com.mxf.course.dao.ClassMapper;
import com.mxf.course.dao.GradeMapper;
import com.mxf.course.dao.SchoolMapper;
import com.mxf.course.dao.StudentMapper;
import com.mxf.course.dto.ClassDto;
import com.mxf.course.entity.ClassEntity;
import com.mxf.course.entity.GradeEntity;
import com.mxf.course.entity.SchoolEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Service
public class ClassService {

    @Resource
    ClassMapper classMapper;

    @Resource
    SchoolMapper schoolMapper;


    @Resource
    GradeMapper gradeMapper;

    @Resource
    StudentMapper studentMapper;

    public PageInfo selectClassByConditions(int currentPage,int pageSize,String classname,String sketch){
        PageHelper.startPage(currentPage,pageSize);
        List<ClassEntity> classEntityList = classMapper.selectClassByConditions(classname, sketch);
        PageInfo pageInfo = new PageInfo<>(classEntityList);
        pageInfo.setList(classEntityList2DtoList(pageInfo.getList()));
        return pageInfo;
    }

    public String insertClass(ClassEntity classEntity) throws ScExtException {
        if (classMapper.insertSelective(classEntity)<0){
            throw new ScExtException("添加班级失败");
        }
        return "success";
    }

    public String updateClass(ClassEntity classEntity) throws ScExtException {
        if (classMapper.updateByPrimaryKeySelective(classEntity)<0){
            throw new ScExtException("添加班级失败");
        }
        return "success";
    }

    public String deleteClass(int id) throws ScExtException {
        if (classMapper.deleteByPrimaryKey(id)<0){
            throw new ScExtException("添加班级失败");
        }
        return "success";
    }

    public List<ClassEntity> selectClassBySchoolId(int id){
        return classMapper.selectClassBySchoolId(id);
    }

    public List<ClassEntity> selectClassByGradeId(int id) {
        return classMapper.selectClassByGradeId(id);
    }

    public PageInfo pageSelectClassByGradeId(int currentPage,int pageSize,int gradeId){
        PageHelper.startPage(currentPage,pageSize);
        List<ClassEntity> classEntityList = classMapper.selectClassByGradeId(gradeId);
        PageInfo pageInfo = new PageInfo<>(classEntityList);
        pageInfo.setList(classEntityList2DtoList(pageInfo.getList()));
        return pageInfo;
    }

    public ClassDto selectClassDetail(int id){
        return classEntity2Dto(classMapper.selectByPrimaryKey(id));
    }

    public List<ClassDto> classEntityList2DtoList(List<ClassEntity> classEntityList){
        List<ClassDto> classDtoList = new ArrayList<>();
        for (ClassEntity classEntity : classEntityList) {
            classDtoList.add(classEntity2Dto(classEntity));
        }
        return classDtoList;
    }

    public ClassDto classEntity2Dto(ClassEntity classEntity){
        if (classEntity == null){
            return null;
        }
        ClassDto classDto = new ClassDto();
        BeanUtils.copyProperties(classEntity,classDto);
        GradeEntity gradeEntity = gradeMapper.selectByPrimaryKey(classEntity.getGradeid());
        if (gradeEntity != null){
            classDto.setGradename(gradeEntity.getGradename());
        }
        SchoolEntity schoolEntity = schoolMapper.selectByPrimaryKey(classEntity.getSchoolid());
        if (schoolEntity!=null){
            classDto.setSchoolname(schoolEntity.getSchoolname());
        }

        int studentCount = studentMapper.selectStudentCountByClassid(classEntity.getId());

        classDto.setStudentnum(studentCount);

        return classDto;
    }
}
