package com.mxf.course.dao;

import com.mxf.course.config.CommMapper;
import com.mxf.course.entity.ClassEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by baimao
 * Time:2021/5/17
 */
@Mapper
public interface ClassMapper extends CommMapper<ClassEntity> {

    @Select("<script>" +
            "select * from yz_jxgl_class where id != -1 " +
            "<if test=\"classname !=null and classname != ''\">" +
            " and classname like concat('%',#{classname},'%')" +
            "</if>" +
            "<if test=\"sketch !=null and sketch != ''\">" +
            " and sketch like concat('%',#{sketch},'%')" +
            "</if>" +
            "order by creatdate desc" +
            "</script>")
    List<ClassEntity> selectClassByConditions(@Param("classname")String classname,
                                              @Param("sketch")String sketch);

    @Select("select * from yz_jxgl_class where schoolid = #{schoolId}")
    List<ClassEntity> selectClassBySchoolId(@Param("schoolId")int schoolId);

    @Select("select * from yz_jxgl_class where gradeid = #{id}")
    List<ClassEntity> selectClassByGradeId(@Param("id") int id);

    @Select("select count(0) from yz_jxgl_class where gradeid = #{gradeid}")
    Integer selectClassCountByGradeId(@Param("gradeid")int gradeid);

    @Select("select count(0) from yz_jxgl_class where schoolid = #{schoolid}")
    Integer selectClassCountBySchoolId(@Param("schoolid")int schoolid);
}
