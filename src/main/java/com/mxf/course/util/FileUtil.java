package com.mxf.course.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

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

    public static List<String> readCsv(File csv) {
        BufferedReader br = null;
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(csv));
            br = new BufferedReader(new InputStreamReader(in, "GBK"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
        List<String> allString = new ArrayList<>();
        try {
            while ((line = br.readLine()) != null) // 读取到的内容给line变量
            {
                everyLine = line;
                System.out.println(everyLine);
                allString.add(everyLine);
            }
            System.out.println("csv表格中所有行数：" + allString.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allString;
    }

    public static File transferToFile(MultipartFile multipartFile) {
//        选择用缓冲区来实现这个转换即使用java 创建的临时文件 使用 MultipartFile.transferto()方法 。
        File file = null;
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            String[] filename = originalFilename.split(".");
            file=File.createTempFile(filename[0], filename[1]);
            multipartFile.transferTo(file);
            file.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
