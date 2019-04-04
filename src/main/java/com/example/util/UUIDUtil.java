package com.example.util;

import java.util.UUID;

/**
 * Created by Administrator on 2019/3/26 0026.
 */
public class UUIDUtil {
    public UUIDUtil() {
    }

    public static String random32UUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String temp = str.substring(0, 8) + str.substring(6, 10) + str.substring(11, 15) + str.substring(16, 20) + str.substring(24);
        return temp.toUpperCase();
    }

    public static String random16UUID() {
        String key = System.currentTimeMillis() + UUID.randomUUID().toString();
        String uuid = Md5Util.MD5(key);
        return uuid.substring(5, 21).toUpperCase();
    }

    public static String getRandom32PK() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
