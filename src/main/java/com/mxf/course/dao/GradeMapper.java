package com.mxf.course.dao;

import com.mxf.course.config.CommMapper;
import com.mxf.course.entity.GradeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Mapper
public interface GradeMapper extends CommMapper<GradeEntity> {

    @Select("<script>" +
            "select * from yz_jxgl_grade where id != -1 " +
            "<if test=\"gradename !=null and gradename != ''\">" +
            " and gradename like concat('%',#{gradename},'%')" +
            "</if>" +
            "<if test=\"year !=null and year != ''\">" +
            " and year like concat('%',#{year},'%')" +
            "</if>" +
            "order by creatdate desc" +
            "</script>")
    List<GradeEntity> selectGradeByConditions(@Param("gradename")String gradename,
                                              @Param("year")String year);

    @Select("select * from yz_jxgl_grade where schoolid = #{schoolid}")
    List<GradeEntity> selectGradesBySchoolId(@Param("schoolid")int schoolId);

    @Select("select count(0) from yz_jxgl_grade where schoolid = #{schoolid}")
    Integer selectGradeCountBySchoolId(@Param("schoolid")int schoolid);
}
