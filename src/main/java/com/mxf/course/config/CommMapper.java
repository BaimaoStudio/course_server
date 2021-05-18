package com.mxf.course.config;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper接口 所有mapper都继承该接口
 * Created by baimao
 * Time:2020/4/10
 */

public interface CommMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
