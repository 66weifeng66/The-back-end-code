package com.system.manage.utils;

import java.util.UUID;

/**
 * @author Created by long qian
 * @version jdk1.8
 * @Description
 * @date 2020/3/19 17:24
 */
public class UUIDGeneratorUtils {
    public static String getId(){
        String id = UUID.randomUUID().toString();
        return id.replace("-","");
    }
}
