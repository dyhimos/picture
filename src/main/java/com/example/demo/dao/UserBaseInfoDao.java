package com.example.demo.dao;

import com.example.demo.baseDao.MyBaseDao;
import com.example.demo.model.dto.UserLoginDto;
import com.example.demo.model.entry.UserBaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/3/23 0023.
 */
@Mapper
@Component
public interface UserBaseInfoDao extends MyBaseDao<UserBaseInfo> {
    public UserBaseInfo loginSelect(UserLoginDto record);

    public UserBaseInfo loginSelectById(String id);
}
