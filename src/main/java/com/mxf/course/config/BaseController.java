package com.mxf.course.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mxf.course.dao.LogMapper;
import com.mxf.course.entity.LogEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 默认控制器，所有的控制器继承该控制器，方可拥有该控制器的所有方法
 * Created by baimao
 * Time:2020/4/2
 */

@Controller
public class BaseController implements InitializingBean {
    @Resource
    LogMapper logMapper;

    static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    public static Gson gsonBuilder = (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss").disableHtmlEscaping().create();

    public BaseController() {
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public String exception(Exception e, HttpServletRequest request, HttpServletResponse response) {
        e.printStackTrace();
        logger.error("#######ERROR#######", e);
        CommResponse<Object> commResponse = new CommResponse();
        commResponse.setStatus(1);
        if (e instanceof ScExtException) {
            commResponse.setErrorMessage(((ScExtException)e).getErrMsg());
        } else {
            String message = e.getMessage();
            commResponse.setErrorMessage(message != null && !message.trim().equals("") ? message : "系统出现错误，请稍后再试");
        }

        Object sn = request.getAttribute("serialno");
        commResponse.setSerialno(sn == null ? "" : sn.toString());
        return gsonBuilder.toJson(commResponse, CommResponse.class);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }

    public <T> String toJson(T content, HttpServletRequest request) {
        CommResponse<T> commResponse = new CommResponse();
        commResponse.setStatus(0);
        commResponse.setErrorMessage("");
        commResponse.setSuccessMessage("success");
        commResponse.setBody(content);
        Object sn = request.getAttribute("serialno");
        commResponse.setSerialno(sn == null ? "" : sn.toString());
        insertLog(commResponse);
        return gsonBuilder.toJson(commResponse, CommResponse.class);
    }

    public void insertLog(CommResponse commResponse){
        LogEntity logEntity = new LogEntity();
        BeanUtils.copyProperties(commResponse,logEntity);
        logEntity.setTime(new Date());
        logEntity.setBody(new Gson().toJson(commResponse.getBody()));
        logMapper.insertSelective(logEntity);
    }
}

