package com.one.mapper;

import com.one.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserInfoMapper {
    //删除
    int deleteByPrimaryKey(Integer userid);

    //添加
    int insert(UserInfo userInfo);

    int insertSelective(UserInfo record);

    //指定查询某个用户
    UserInfo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserInfo record);

    //修改
    int updateByPrimaryKey(UserInfo record);

    //盐值
    UserInfo getStaffByUserName(String useraccount);

    //查询所有的信息
    List<UserInfo> findAll();

    //模糊查询
    List<UserInfo> selectByuserName(String string);

    //根据selectBymanagerName查询信息
    List<UserInfo> selectBymanagerName(String managerName);

    //根据useraccount查询信息
    UserInfo selectbyaccount(String useraccount);
}