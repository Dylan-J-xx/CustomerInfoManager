package com.one.service;

import com.one.model.ManagerInfo;

import java.util.HashMap;

public interface ManagerService {
    //登录查询
    HashMap<String, Object> login(ManagerInfo managerinfo);

    //分页查询
    HashMap<String, Object> findAllManagerByPage(Integer pageNum, Integer row);

    //删除
    HashMap<String, Object> deleteByPrimaryKey(Integer managerId);

    //添加
    HashMap<String, Object> insert(ManagerInfo managerinfo);

    //修改
    HashMap<String, Object> update(ManagerInfo managerinfo);

    //指定查询
    HashMap<String, Object> selectByPrimaryKey(Integer managerId);

    //模糊查询
    HashMap<String, Object> selectBymanagerName(String managerName);
}
