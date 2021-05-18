package com.mxf.course.config;

import com.mxf.course.util.CommandUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by baimao
 * Time:2021/5/18
 */

@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        CommandUtil.run("tail -f D:\\Squid\\var\\log\\squid\\access.log");
    }
}
