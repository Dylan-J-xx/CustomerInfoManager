package com.one.service;

import com.one.model.Service;

import java.text.ParseException;
import java.util.HashMap;


public interface ServiceService {
    //查询服务表
    HashMap<String, Object> findAllserviceByPage(int pageNum, int row);

    //增加
    HashMap<String, Object> insertSelective(Service service);

    //删除
    HashMap<String, Object> deleteByPrimaryKey(Integer serviceid);

    //修改
    HashMap<String, Object> updateByPrimaryKeySelective(Service record) throws ParseException;

    //模糊查询
    HashMap<String, Object> selectByserviceName(String string);

    //根据serviceid查询服务
    HashMap<String, Object> selectByserviceid(Integer serviceid);
}
