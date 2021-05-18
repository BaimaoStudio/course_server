package com.mxf.course.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by baimao
 * Time:2020/11/29
 */

public class FileUtil {


    public static void uploadFile(MultipartFile file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath+fileName);
        if(!targetFile.getParentFile().exists()){
            targetFile.getParentFile().mkdir();
        }
        file.transferTo(targetFile);
    }
}
