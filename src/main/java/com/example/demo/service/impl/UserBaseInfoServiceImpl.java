package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.UserBaseInfoDao;
import com.example.demo.exception.UserBizException;
import com.example.demo.model.dto.UserLoginDto;
import com.example.demo.model.entry.UserBaseInfo;
import com.example.demo.service.UserBaseInfoService;
import com.example.demo.util.UUIDUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2019/3/23 0023.
 */
@Slf4j
@Service
public class UserBaseInfoServiceImpl implements UserBaseInfoService {
    @Autowired
    private UserBaseInfoDao dao;


    /**
     * 添加用户
     *
     * @param
     */
    public String addUser(UserBaseInfo dto) {
        log.info("----- 进入添加用户流程，输入参数： " + JSONObject.toJSONString(dto));
        UserBaseInfo userBaseInfo = new UserBaseInfo();
        BeanUtils.copyProperties(dto, userBaseInfo);
        userBaseInfo.setId(UUIDUtil.getRandom32PK());
        userBaseInfo.setCreateDate(new Date());
        userBaseInfo.setUpdateDate(new Date());
        dao.insert(userBaseInfo);
        return "0";
    }


    /**
     * 登录
     *
     * @param
     */
    public UserLoginDto loginIn(UserLoginDto dto) {
        log.info("----- 进入登录流程，输入参数：" + JSONObject.toJSONString(dto));
        UserBaseInfo temp = new UserBaseInfo();
        temp.setUbiLoginName(dto.getUbiLoginName());
        UserBaseInfo userBaseInfo = null;
        try {
            userBaseInfo = dao.selectOne(temp);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UserBizException("用户名或密码错误！");
        }
        if(dto.getPassword().equals(userBaseInfo.getUbiPassword())){
            BeanUtils.copyProperties(userBaseInfo,dto);
        }else{
            throw new UserBizException("用户名或密码错误！");
        }
        log.info("----- 登录结果：" + JSONObject.toJSONString(dto));
        return dto;
    }

}
