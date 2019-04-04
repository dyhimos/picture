package com.example.demo.web.rest;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.dto.UserLoginDto;
import com.example.demo.model.entry.UserBaseInfo;
import com.example.demo.model.vo.WrapMapper;
import com.example.demo.service.UserBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.invoke.util.Wrapper;


/**
 * Created by Administrator on 2019/3/23 0023.
 */
@Api(description = "用户接口")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserBaseInfoService userBaseInfoService;

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello spring boot";
    }


    /**
     * 用户登录
     * @param
     * @return
     */
    @PostMapping(value = "/login")
    @ApiOperation(httpMethod = "POST", value = "用户登录")
    public JSONObject update(@RequestBody UserLoginDto dto){
        log.info("---- 登录输入参数：" + JSONObject.toJSONString(dto));
        userBaseInfoService.loginIn(dto);
        return WrapMapper.ok();
    }


    /**
     * 添加用户
     * @param
     * @return
     */
    @PostMapping(value = "/addUser")
    @ApiOperation(httpMethod = "POST", value = "添加用户")
    public JSONObject addUser(@RequestBody UserBaseInfo dto){
        log.info("---- 登录输入参数：" + JSONObject.toJSONString(dto));
        try {
            userBaseInfoService.addUser(dto);
        } catch (Exception e) {
            e.printStackTrace();
            return WrapMapper.error("网络异常，请稍后再试！");
        }
        return WrapMapper.ok();
    }

}
