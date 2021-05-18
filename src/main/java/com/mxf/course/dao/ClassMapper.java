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
}
