//package com.mxf.course.dao;
//
//import com.mxf.course.config.CommMapper;
//import com.mxf.course.entity.StudentEntity;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
//
//import java.util.List;
//
///**
// * Created by baimao
// * Time:2021/5/17
// */
//
//@Mapper
//public interface StudentMapper extends CommMapper<StudentEntity> {
//    @Select("<script>" +
//            "select * from yz_jxgl_teacher where id != -1 " +
//            "<if test=\"nickname !=null and nickname != ''\">" +
//            " and uid in (select id from yz_user where nickname like concat('%',#{nickname},'%') ) " +
//            "</if>" +
//            "<if test=\"username !=null and username != ''\">" +
//            " and uid in (select id from yz_user where username like concat('%',#{username},'%') ) " +
//            "</if>" +
//            "order by regtime desc" +
//            "</script>")
//    List<StudentEntity> selectStudentsByConditions(@Param("nickname")String nickname,
//                                                   @Param("username")String username);
//}
