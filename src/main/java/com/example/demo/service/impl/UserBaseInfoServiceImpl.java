package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.UserBaseInfoDao;
import com.example.demo.model.dto.UserLoginDto;
import com.example.demo.model.entry.UserBaseInfo;
import com.example.demo.service.UserBaseInfoService;
import com.example.util.UUIDUtil;
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
    public String addUser(UserBaseInfo dto){
        log.info("----- 进入添加用户流程，输入参数： "+ JSONObject.toJSONString(dto));
        UserBaseInfo userBaseInfo = new UserBaseInfo();
        BeanUtils.copyProperties(dto,userBaseInfo);
        userBaseInfo.setId(UUIDUtil.getRandom32PK());
        userBaseInfo.setCreateDate(new Date());
        userBaseInfo.setUpdateDate(new Date());
        dao.insert(userBaseInfo);
        //int n = dao.insert(dto);
        return "0";
    }


    /**
     * 登录
     *
     * @param
     */
    public UserLoginDto loginIn(UserLoginDto dto) {
        try {
            dao.loginSelect(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UserBaseInfo userBaseInfo = null;
        try {
            userBaseInfo = dao.loginSelectById(dto.getLoginId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UserBaseInfo userBaseInfo1 = new UserBaseInfo();
        userBaseInfo1.setId(dto.getLoginId());
        //dao.insert(userBaseInfo);

        log.info("-----" + JSONObject.toJSONString(userBaseInfo));
        return null;
    }

}
