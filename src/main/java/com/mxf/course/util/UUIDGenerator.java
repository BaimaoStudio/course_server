package com.mxf.course.util;

import java.util.UUID;

/**
 * Created by baimao
 * Time:2020/4/3
 */

public class UUIDGenerator {

    /**
     * 生成32位UUID （不重复）
     * @return
     */
    public static String getUUID32() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }

}
