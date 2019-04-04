package com.example.demo.baseDao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by Administrator on 2019/3/24 0024.
 */
public interface MyBaseDao<T> extends Mapper<T>, MySqlMapper<T> {

}
