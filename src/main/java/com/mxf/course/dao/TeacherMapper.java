package com.mxf.course.dao;

import com.mxf.course.config.CommMapper;
import com.mxf.course.entity.TeacherEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Mapper
public interface TeacherMapper extends CommMapper<TeacherEntity> {

    @Select("<script>" +
            "select * from yz_jxgl_teacher where id != -1 " +
            "<if test=\"teachername !=null and teachername != ''\">" +
            " and teachername like concat('%',#{teachername},'%')" +
            "</if>" +
            "order by expiredate desc" +
            "</script>")
    List<TeacherEntity> selectTeacherByConditions(@Param("teachername")String teachername);
}
