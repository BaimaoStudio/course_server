package com.mxf.course.config;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by baimao
 * Time:2020/4/10
 */

public class CommService {

    public <T> PageInfo  pageSelect(int currentPage, int pageSize, List<T> list){
        PageHelper.startPage(currentPage,pageSize);
        return new PageInfo(list);
    }
}
