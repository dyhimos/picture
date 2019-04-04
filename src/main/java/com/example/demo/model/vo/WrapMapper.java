package com.example.demo.model.vo;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Administrator on 2019/3/23 0023.
 */
public class WrapMapper {

    public static JSONObject wrap(int code, String message, Object o) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", code);
        jsonObject.put("message", message);
        jsonObject.put("result", null == o ? null : JSONObject.toJSONString(o));
        return jsonObject;
    }

    public static JSONObject error() {
        return wrap(500, "内部异常！", null);
    }

    public static JSONObject error(String message) {
        return wrap(500, StringUtils.isBlank(message) ? "内部异常" : message, null);
    }

    public static JSONObject ok() {
        return wrap(200, "交易成功！", null);
    }

    public static JSONObject ok(Object o) {
        return wrap(200, "操作成功", o);
    }
}
