package com.mxf.course.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * Created by baimao
 * Time:2020/4/5
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    /**
     * 浏览器路径映射到本地路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        System.out.println("==============start config===============");
        String dirPath = "/usr/upload/";
        File file = new File(dirPath);
        if (!file.exists()){
            file.mkdirs();
        }
        registry.addResourceHandler("/upload/**")
//                .addResourceLocations("file:"+"D://upload/");
                  .addResourceLocations("file:"+dirPath);
    }
}
