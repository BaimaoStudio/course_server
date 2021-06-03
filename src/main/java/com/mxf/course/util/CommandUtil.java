package com.mxf.course.util;

import com.mxf.course.websocket.WebSocketService;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by baimao
 * Time:2021/5/18
 */

public class CommandUtil {

    private static long lastTimeFileSize = 0;  //上次文件大小

    private static volatile String p="";
    /**
     * 实时输出日志信息
     * @throws IOException
     */
    public static void realtimeShowLog(String port) throws IOException{
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        exec.scheduleWithFixedDelay(() -> {
            try {
                //获得变化部分的
                Process process = Runtime.getRuntime().exec("ssh localhost -p" + port +" tail -f /var/log/squid/access.log ");
                InputStream inputStream =  process.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String tmp = "";
                while( (tmp = bufferedReader.readLine())!= null) {
                    System.out.println(new String(tmp.getBytes("ISO8859-1")));
                    WebSocketService.broadcast("machineId",tmp);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
    public static String run2(String command) throws IOException {
        Scanner input = null;
        String result = "";
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(command);
            try {
                //等待命令执行完成
                process.waitFor(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            InputStream is = process.getInputStream();
            input = new Scanner(is);
            while (input.hasNextLine()) {
                String re = input.nextLine();
                result += re + "\n";
            }
        } finally {
            if (input != null) {
                input.close();
            }
            if (process != null) {
                process.destroy();
            }
        }
        return result;
    }
}
