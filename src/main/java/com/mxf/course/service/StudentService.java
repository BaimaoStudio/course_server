package com.mxf.course.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxf.course.config.ScExtException;
import com.mxf.course.dao.ClassMapper;
import com.mxf.course.dao.GradeMapper;
import com.mxf.course.dao.SchoolMapper;
import com.mxf.course.dao.StudentMapper;
import com.mxf.course.dto.StudentDto;
import com.mxf.course.dto.UserDto;
import com.mxf.course.entity.ClassEntity;
import com.mxf.course.entity.GradeEntity;
import com.mxf.course.entity.SchoolEntity;
import com.mxf.course.entity.StudentEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Service
public class StudentService {

    @Resource
    StudentMapper studentMapper;

    @Resource
    GradeMapper gradeMapper;

    @Resource
    ClassMapper classMapper;

    @Resource
    SchoolMapper schoolMapper;

    public PageInfo selectStudentsByConditions(int currentPage,int pageSize,String nickname,String username,String gradename,String schoolname){
        PageHelper.startPage(currentPage,pageSize);
        List<StudentEntity> list = studentMapper.selectStudentsByConditions(nickname, username,gradename,schoolname);
        PageInfo pageInfo = new PageInfo<>(list);
        pageInfo.setList(entity2dto(pageInfo.getList()));
        return pageInfo;
    }

    public String insertStudent(StudentEntity studentEntity,UserDto userDto) throws ScExtException {

        if (studentMapper.insertUser(userDto.getUsername(),userDto.getNickname())<0){
            throw new ScExtException("添加学生失败--002");
        }
        Map map = studentMapper.selectUserByParams(userDto.getUsername(),userDto.getNickname());
        int id = Integer.parseInt(String.valueOf(map.get("id")));
        studentEntity.setUid(id);
        if (studentMapper.insertSelective(studentEntity)<0){
            throw new ScExtException("添加学生失败--001");
        }

        return "success";
    }

    public List<StudentDto> entity2dto(List<StudentEntity> studentEntityList){
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (int i = 0; i < studentEntityList.size(); i++) {
            StudentDto studentDto = new StudentDto();
            StudentEntity studentEntity = studentEntityList.get(i);
            studentDto.setId(studentEntity.getId());
            studentDto.setCreatdate(studentEntity.getRegtime());
            System.out.println(studentEntity.getUid());
           Map map = studentMapper.selectUserByStudentId(studentEntity.getUid());
            if (map != null){
                System.out.println(map.toString());
                studentDto.setNickname(String.valueOf(map.get("nickname")));
                studentDto.setUsername(String.valueOf(map.get("username")));
            }
            ClassEntity classEntity = classMapper.selectByPrimaryKey(studentEntity.getClassid());
            if (classEntity!=null){
                studentDto.setClassname(classEntity.getClassname());
            }
            SchoolEntity schoolEntit = schoolMapper.selectByPrimaryKey(studentEntity.getSchoolid());
            if (schoolEntit!=null){
                studentDto.setSchoolname(schoolEntit.getSchoolname());
                studentDto.setSchoolid(studentEntity.getSchoolid());
            }

            GradeEntity gradeEntity = gradeMapper.selectByPrimaryKey(studentEntity.getGradeid());
            if (gradeEntity!=null){
                studentDto.setGradename(gradeEntity.getGradename());
            }
            studentDtoList.add(studentDto);
        }
        return studentDtoList;
    }
}
