package com.one.mapper;

import com.one.model.ManagerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManagerInfoMapper {
    int deleteByPrimaryKey(Integer managerid);

    int insert(ManagerInfo record);

    int insertSelective(ManagerInfo record);

    ManagerInfo selectByPrimaryKey(Integer managerid);

    int updateByPrimaryKeySelective(ManagerInfo record);

    int updateByPrimaryKey(ManagerInfo record);

    ManagerInfo getStaffByUserName(String mangeraccount);

    //查找所有
    List<ManagerInfo> findAll();

    //模糊查询
    List<ManagerInfo> selectBymanagerName(String string);

    ManagerInfo selectbyaccount(String manageraccount);
}