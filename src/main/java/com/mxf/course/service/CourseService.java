package com.mxf.course.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxf.course.config.ScExtException;
import com.mxf.course.dao.CourseMapper;
import com.mxf.course.entity.CourseEntity;
import com.mxf.course.entity.SchoolEntity;
import com.mxf.course.util.PPT2HtmlUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Service
public class CourseService {

    @Value("${image.dirpath}")
    String dirPath;

    @Value("${image.webpath}")
    String webpath;


    @Resource
    CourseMapper courseMapper;

    public PageInfo selectCourseByConditions(int currentPage,int pageSize,String coursename,String sketch){
        PageHelper.startPage(currentPage,pageSize);
        List<CourseEntity> list = courseMapper.selectCourseByConditions(coursename, sketch);
        PageInfo pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public String insertCourse(CourseEntity courseEntity) throws Exception {
        String contentUrl = courseEntity.getContent();
        if (contentUrl != null){
            String [] urls = contentUrl.split(";");
            String result = "<body>";
            for (String url : urls) {
                String tempUrl = url.replace(webpath,dirPath).replace("/","\\");
                result += PPT2HtmlUtil.ppt2Html(new File(tempUrl));
            }
            courseEntity.setContent(result+"</body>");
        }
        if (courseMapper.insertSelective(courseEntity)<0){
            throw new ScExtException("添加课程失败");
        }
        return "success";
    }

    public CourseEntity selectOneCourse(int id){
        return courseMapper.selectByPrimaryKey(id);
    }
    public String updateCourse(CourseEntity courseEntity) throws Exception {
        String contentUrl = courseEntity.getContent();
        if (contentUrl != null){
            String [] urls = contentUrl.split(";");
            String result = "<body>";
            for (String url : urls) {
                String tempUrl = url.replace(webpath,dirPath).replace("/","\\");
                result += PPT2HtmlUtil.ppt2Html(new File(tempUrl));
            }
            courseEntity.setContent(result+"</body>");
        }
        if (courseMapper.updateByPrimaryKeySelective(courseEntity)<0){
            throw new ScExtException("修改课程失败");
        }
        return "success";
    }

    public String deleteCourse(int id) throws ScExtException {
        if (courseMapper.deleteByPrimaryKey(id)<0){
            throw new ScExtException("删除课程失败");
        }
        return "success";
    }
}
