package com.mxf.course.controller;

import com.mxf.course.config.BaseController;
import com.mxf.course.config.ScExtException;
import com.mxf.course.service.CourseService;
import com.mxf.course.util.FileUtil;
import com.mxf.course.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Controller
@RequestMapping("/api/v1/course")
public class CourseController extends BaseController {

    @Value("${image.dirpath}")
    String dirPath;

    @Value("${image.webpath}")
    String webpath;

    @Autowired
    CourseService courseService;

    @RequestMapping("selectCourseByConditions")
    public @ResponseBody String selectCourseByConditions(@RequestParam("currentPage")int currentPage,
                                                         @RequestParam("pageSize")int pageSize,
                                                             @RequestParam(value = "coursename",required = false)String coursename,
                                                         @RequestParam(value = "sketch",required = false)String sketch,
                                                         HttpServletRequest request){
        return toJson(courseService.selectCourseByConditions(currentPage, pageSize, coursename, sketch),request);
    }

    @RequestMapping(value = "/upload")
    public @ResponseBody String upload(@RequestParam("file") MultipartFile file,
                                       HttpServletRequest request) throws IOException, ScExtException {
        //1. 接受上传的文件  @RequestParam("file") MultipartFile file

        if (file == null ){
            throw new ScExtException("文件不存在，请重新上传");
        }
        String fileTail = file.getOriginalFilename().split("\\.")[1];
        String fileName = UUIDGenerator.getUUID32()+"."+fileTail;
        //设置文件上传路径
        String filePath = request.getSession().getServletContext().getRealPath(dirPath);
        filePath = dirPath;
        try {
            FileUtil.uploadFile(file, filePath,fileName);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ScExtException("上传失败");
        }
        String url = webpath+"/"+fileName;
        return toJson(url,request);
    }

}
