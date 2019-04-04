package com.example.demo.service;

import com.example.demo.model.dto.UserLoginDto;
import com.example.demo.model.entry.UserBaseInfo;

/**
 * Created by Administrator on 2019/3/23 0023.
 */
public interface UserBaseInfoService {

    /**
     *  添加用户
     *
     * @param
     */
    public String addUser(UserBaseInfo dto);


    /**
     * 登录
     *
     * @param
     */
    public UserLoginDto loginIn(UserLoginDto dto);
}
