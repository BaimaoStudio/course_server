package com.mxf.course.dao;

import com.mxf.course.entity.LogEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * Created by baimao
 * Time:2021/5/28
 */

@Mapper
public interface LogMapper extends BaseMapper<LogEntity> {


}
