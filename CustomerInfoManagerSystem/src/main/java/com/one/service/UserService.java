package com.one.service;

import com.one.model.UserInfo;

import java.util.HashMap;

public interface UserService {
    //登录查询
    HashMap<String, Object> login(UserInfo userInfo);

    //分页查询
    HashMap<String, Object> findAllUserByPage(Integer pageNum, Integer row);

    //删除
    HashMap<String, Object> deleteByPrimaryKey(Integer userId);

    //添加
    HashMap<String, Object> insert(UserInfo userInfo);

    //修改
    HashMap<String, Object> update(UserInfo userInfo);

    //指定查询
    HashMap<String, Object> selectByPrimaryKey(Integer userId);

    //模糊查询
    HashMap<String, Object> selectByuserName(String string);

    //分页查找指定联系人
    HashMap<String, Object> findAllManagerUserByPage(int pageNum, int row, String managerName);


}
