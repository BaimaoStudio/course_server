package com.mxf.course.dao;

import com.mxf.course.config.CommMapper;
import com.mxf.course.entity.SquidEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by baimao
 * Time:2021/5/25
 */

@Mapper
public interface SquidMapper extends CommMapper<SquidEntity> {


    @Select("<script>" +
            "select * from yz_squid where id != -1 " +
            "<if test=\"port !=null and port != ''\">" +
            " and outport like concat('%',#{port},'%')" +
            "</if>" +
            "<if test=\"name !=null and name != ''\">" +
            " and name concat('%',#{name},'%')" +
            "</if>" +
            "<if test=\"ip !=null and ip != ''\">" +
            " and ip concat('%',#{ip},'%')" +
            "</if>" +
            "order by date desc" +
            "</script>")
    List<SquidEntity> selectAllSquidByConditions(@Param("port")String port,
                                                 @Param("ip")String ip,
                                                 @Param("name")String name);

    @Select("select * from yz_squid where name = #{name}")
    SquidEntity selectSquidByName(@Param("name")String name);

    @Select("select outport from yz_squid ")
    List<Integer> selectAllPorts();

    @Select("select * from yz_squid where outport = #{port}")
    SquidEntity selectSquidByPorts(@Param("port")int ports);
}
