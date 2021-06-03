package com.mxf.course.config;

import com.mxf.course.dao.SquidMapper;
import com.mxf.course.service.SquidService;
import com.mxf.course.util.CommandUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * Created by baimao
 * Time:2021/5/27
 */


@Component
public class SchedulTask {

    @Autowired
    SquidService squidService;

    public SquidService getSquidService(){
        return squidService;
    }

    public void setSquidService(SquidService squidService) {
        this.squidService = squidService;
    }

    @Scheduled(fixedDelay = 300 * 1000)
    public void testTask() throws ScExtException {
        String result = null;
        try {

            result = CommandUtil.run2("netstat -tunlp|grep sshd| grep root|awk '{print $4}'|awk -F ':' '{print $2}'");
            System.out.println(result);
            result = CommandUtil.run2("netstat -tunlp|grep sshd| grep root");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result == null){
            return;
        }
        String[] strs = result.split("\n");
        List<Integer> squidPortsList = squidService.selectAllSquidPort();
        List<Integer> squidPortsList2 = squidPortsList;
        if (squidPortsList == null){
            return;
        }
        for (int i = 0 ; i < squidPortsList.size(); i++){
            for (String str : strs){
                System.out.println(str);
                if (str.trim().equals(squidPortsList.get(i).toString())){
                    //如果查到相同的就将状态更新为在线
                    squidService.updateSquid(squidPortsList.get(i),0);
                    squidPortsList2.remove(i);
                }
            }
        }
        //其余的更新为不在线
        for (int i = 0; i < squidPortsList2.size(); i++) {
            squidService.updateSquid(squidPortsList.get(i),1);
        }
    }
}
