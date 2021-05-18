package com.mxf.course.dao;

import com.mxf.course.config.CommMapper;
import com.mxf.course.entity.SchoolEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Mapper
public interface SchoolMapper extends CommMapper<SchoolEntity> {

    @Select("<script>" +
            "select * from yz_jxgl_school where id != -1 " +
            "<if test=\"schoolname !=null and schoolname != ''\">" +
            " and schoolname like concat('%',#{schoolname},'%')" +
            "</if>" +
            "<if test=\"sketch !=null and sketch != ''\">" +
            " and sketch like concat('%',#{sketch},'%')" +
            "</if>" +
            "<if test=\"province !=null and province != ''\">" +
            " and province like concat('%',#{province},'%')" +
            "</if>" +
            "<if test=\"city !=null and city != ''\">" +
            " and city like concat('%',#{city},'%')" +
            "</if>" +
            "<if test=\"district !=null and district != ''\">" +
            " and district like concat('%',#{district},'%')" +
            "</if>" +
            "order by creatdate desc" +
            "</script>")
    List<SchoolEntity> selectSchoolEntityByConditions(@Param("schoolname")String schoolname,
                                                      @Param("sketch")String sketch,
                                                      @Param("province")String province,
                                                      @Param("city")String city,
                                                      @Param("district")String district);


}
