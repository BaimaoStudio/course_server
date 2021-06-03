package com.mxf.course.dao;

import com.mxf.course.config.CommMapper;
import com.mxf.course.dto.UserDto;
import com.mxf.course.entity.StudentEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Mapper
public interface StudentMapper extends CommMapper<StudentEntity>{
    @Select("<script>" +
            "select * from yz_jxgl_teacher where id != -1 " +
            "<if test=\"nickname !=null and nickname != ''\">" +
            " and uid in (select id from yz_user where nickname like concat('%',#{nickname},'%') ) " +
            "</if>" +
            "<if test=\"username !=null and username != ''\">" +
            " and uid in (select id from yz_user where username like concat('%',#{username},'%') ) " +
            "</if>" +
            "<if test=\"schoolname !=null and schoolname != ''\">" +
            " and schoolid in (select id from yz_jxgl_school where schoolname like concat('%',#{schoolname},'%') ) " +
            "</if>" +
            "<if test=\"gradename !=null and gradename != ''\">" +
            " and gradeid in (select id from yz_jxgl_grade where gradename like concat('%',#{gradename},'%') ) " +
            "</if>" +
            "order by regtime desc" +
            "</script>")
    List<StudentEntity> selectStudentsByConditions(@Param("nickname")String nickname,
                                                   @Param("username")String username,
                                                   @Param("gradename")String gradename,
                                                   @Param("schoolname")String schoolname);

    @Select("select * from yz_user where id = #{id}")
    Map selectUserByStudentId(@Param("id")int id);

    @Select("select * from yz_user where username = #{username} and nickname = #{nickname}")
    Map selectUserByParams(@Param("username")String username,
                           @Param("nickname")String nickname);

    @Select("select count(0) from yz_jxgl_student where schoolid = #{schoolid}")
    Integer selectStudentCountBySchoolid(@Param("schoolid")int schoolid);
    @Select("select count(0) from yz_jxgl_student where gradeid = #{gradeid}")
    Integer selectStudentCountByGradeid(@Param("gradeid")int gradeid);
    @Select("select count(0) from yz_jxgl_student where classid = #{classid}")
    Integer selectStudentCountByClassid(@Param("classid")int classid);
    @Insert("insert into yz_user (username,password,nickname) values(#{username},#{username},#{nickname})")
    Integer insertUser(@Param("username")String username,
                      @Param("nickname")String nickname);
}
