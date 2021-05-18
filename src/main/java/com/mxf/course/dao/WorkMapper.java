package com.mxf.course.dao;

import com.mxf.course.config.CommMapper;
import com.mxf.course.entity.WorkEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Mapper
public interface WorkMapper extends CommMapper<WorkEntity> {
}
