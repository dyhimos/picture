package com.example.demo.util;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * Created by Administrator on 2019/3/26 0026.
 */
public class Md5Util {
    private static final String CHARSET = "UTF-8";

    public Md5Util() {
    }

    public static final String MD5(String content) {
        return MD5(content, "UTF-8").toUpperCase();
    }

    public static final String MD5(String content, String charset) {
        return DigestUtils.md5DigestAsHex(getContentBytes(content, charset));
    }

    public static final String MD5(String content, String key, String charset) {
        content = content + key;
        return MD5(content, charset);
    }

    public static boolean verify(String text, String sign, String key, String charset) {
        text = text + key;
        return verify(text, sign, charset);
    }

    public static boolean verify(String text, String sign) {
        return verify(text, sign, "UTF-8");
    }

    public static boolean verify(String text, String sign, String charset) {
        String mysign = MD5(text, charset);
        return mysign.equals(sign);
    }

    private static byte[] getContentBytes(String content, String charset) {
        if(StringUtils.isEmpty(charset)) {
            return content.getBytes();
        } else {
            try {
                return content.getBytes(charset);
            } catch (UnsupportedEncodingException var3) {
                throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
            }
        }
    }
}
