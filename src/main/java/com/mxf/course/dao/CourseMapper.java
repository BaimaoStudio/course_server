package com.mxf.course.dao;

import com.mxf.course.config.CommMapper;
import com.mxf.course.entity.CourseEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Mapper
public interface CourseMapper extends CommMapper<CourseEntity> {

    @Select("<script>" +
            "select * from yz_jxgl_course where id != -1 " +
            "<if test=\"coursename !=null and coursename != ''\">" +
            " and coursename like concat('%',#{coursename},'%')" +
            "</if>" +
            "<if test=\"sketch !=null and sketch != ''\">" +
            " and sketch like concat('%',#{sketch},'%')" +
            "</if>" +
            "</script>")
    List<CourseEntity> selectCourseByConditions(@Param("coursename")String coursename,
                                                @Param("sketch")String sketch);
}
