package com.one.mapper;

import com.one.model.Superadmin;
import com.one.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface SuperadminMapper {
    int insert(Superadmin record);

    int insertSelective(Superadmin record);

    Superadmin login(Superadmin superadmin);

    //根据account查询信息
    Superadmin selectbyaccount(String superadimaccount);

}