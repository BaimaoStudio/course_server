package com.mxf.course.controller;

import com.mxf.course.config.BaseController;
import com.mxf.course.config.ScExtException;
import com.mxf.course.dto.StudentDto;
import com.mxf.course.dto.UserDto;
import com.mxf.course.entity.StudentEntity;
import com.mxf.course.service.StudentService;
import com.mxf.course.util.FileUtil;
import com.mxf.course.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by baimao
 * Time:2021/5/17
 */

@Controller
@RequestMapping("/api/v1/student")
public class StudentController extends BaseController {

    @Value("${image.dirpath}")
    String dirPath;

    @Value("${image.webpath}")
    String webpath;


    @Autowired
    StudentService studentService;

    @RequestMapping("selectStudentsByConditions")
    public @ResponseBody String selectStudentsByConditions(@RequestParam("currentPage") int currentPage,
                                                           @RequestParam("pageSize")int pageSize,
                                                           @RequestParam(value = "nickname",required = false) String nickname,
                                                           @RequestParam(value = "username",required = false)String username,
                                                           @RequestParam(value = "gradename",required = false)String gradename,
                                                           @RequestParam(value = "schoolname",required = false)String schoolname,

                                                           HttpServletRequest request){
        return toJson(studentService.selectStudentsByConditions(currentPage, pageSize, nickname, username,gradename,schoolname),request);
    }

    @RequestMapping(value = "/insertStudents")
    public @ResponseBody String upload(@RequestBody Map map,
                                       HttpServletRequest request) throws IOException, ScExtException {
        //1. 接受上传的文件  @RequestParam("file") MultipartFile file
        String fileUrl = String.valueOf(map.get("fileUrl")).replace(webpath,dirPath);
        System.out.println(fileUrl);
        int schoolid = Integer.parseInt(String.valueOf(map.get("schoolid")));
        int gradeid = Integer.parseInt(String.valueOf(map.get("gradeid")));
        int classid = Integer.parseInt(String.valueOf(map.get("classid")));
        File file = new File(fileUrl);
        String fileTail = file.getName().split("\\.")[1];
        if (!"csv".equals(fileTail)){
            throw new ScExtException("文件格式错误，请上传.csv文件");
        }
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setClassid(classid);
        studentEntity.setGradeid(gradeid);
        studentEntity.setSchoolid(schoolid);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        int time = Integer.parseInt(simpleDateFormat.format(new Date()));
        studentEntity.setRegtime(time);
        List<String> resList = FileUtil.readCsv(file);
        for (String s : resList) {
            String[] strs = s.split(",");
            UserDto userDto = new UserDto();
            for (int i = 0; i < strs.length; i++) {
                userDto.setUsername(strs[1]);
                userDto.setNickname(strs[0]);
                studentService.insertStudent(studentEntity,userDto);
            }
        }
        return toJson(resList,request);
    }
}
