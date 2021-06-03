package com.mxf.course.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxf.course.config.ScExtException;
import com.mxf.course.dao.ClassMapper;
import com.mxf.course.dao.GradeMapper;
import com.mxf.course.dao.SchoolMapper;
import com.mxf.course.dao.StudentMapper;
import com.mxf.course.dto.GradeDetailDto;
import com.mxf.course.entity.GradeEntity;
import com.mxf.course.entity.SchoolEntity;
import org.springframework.beans.BeanUtils;
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
    @Resource
    SchoolMapper schoolMapper;

    @Resource
    ClassMapper classMapper;
    @Resource
    StudentMapper studentMapper;

    public PageInfo selectGradeByConditions(int currentPage,int pageSize, String gradename, String year){
        PageHelper.startPage(currentPage,pageSize);
        List<GradeEntity> gradeEntityList = gradeMapper.selectGradeByConditions(gradename, year);
        PageInfo pageInfo = new PageInfo<>(gradeEntityList);
        return pageInfo;
    }

    public List<GradeEntity> selectGradesBySchoolId(int id){
        return gradeMapper.selectGradesBySchoolId(id);
    }

    public PageInfo pageSelectGradesBySchoolId(int currentPage,int pageSize,int schoolId){
        PageHelper.startPage(currentPage,pageSize);
        List<GradeEntity> gradeEntityList = gradeMapper.selectGradesBySchoolId(schoolId);
        PageInfo pageInfo = new PageInfo(gradeEntityList);
        return pageInfo;
    }

    public String insertGrade(GradeEntity gradeEntity) throws ScExtException {
        if (gradeMapper.insertSelective(gradeEntity)<0){
            throw new ScExtException("添加年级失败");
        }
        return "success";
    }
    public String updateGrade(GradeEntity gradeEntity) throws ScExtException {
        if (gradeMapper.updateByPrimaryKeySelective(gradeEntity)<0){
            throw new ScExtException("修改年级失败");
        }
        return "success";
    }


    public GradeDetailDto selectGradeDetail(int id){
        GradeEntity gradeEntity = gradeMapper.selectByPrimaryKey(id);
        return gradeEntity2Dto(gradeEntity);
    }

    public String deleteGrade(int id) throws ScExtException {
        if (gradeMapper.deleteByPrimaryKey(id)<0){
            throw new ScExtException("删除年级失败");
        }
        return "success";
    }

    public GradeDetailDto gradeEntity2Dto(GradeEntity gradeEntity) {
        if (gradeEntity == null){
            return null;
        }
        GradeDetailDto gradeDetailDto = new GradeDetailDto();
        BeanUtils.copyProperties(gradeEntity,gradeDetailDto);
        SchoolEntity schoolEntity = schoolMapper.selectSchoolByGradeId(gradeEntity.getId());
        if (schoolEntity == null ){
            gradeDetailDto.setSchoolname("无");
        }

        int classCount = classMapper.selectClassCountByGradeId(gradeEntity.getId());
        gradeDetailDto.setClassnum(classCount);

        int studentCount = studentMapper.selectStudentCountByGradeid(gradeEntity.getId());
        gradeDetailDto.setStudentnum(studentCount);
        return gradeDetailDto;
    }
}
