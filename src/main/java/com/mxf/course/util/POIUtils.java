package com.mxf.course.util;

/**
 * Created by baimao
 * Time:2021/6/1
 */


import java.io.File;
import java.util.UUID;

/**
 * @author TangFD@HF 2018/5/29
 */
public class POIUtils {
    public static void createDir(String dirPath) {
        File file = new File(dirPath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static String dealTargetDir(String targetDir) {
        targetDir = targetDir == null ? "" : targetDir;
        if (!targetDir.isEmpty()) {
            createDir(targetDir);
        }

        if (!targetDir.endsWith(File.separator)) {
            targetDir += File.separator;
        }
        return targetDir;
    }

    public static File checkFileExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("file not exists ![filepath = " + filePath + "]");
        }

        return file;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}