package com.one.mapper;

import com.one.model.Service;
import com.one.model.ServiceLinkUandM;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ServiceMapper {
    int deleteByPrimaryKey(Integer serviceid);

    int insert(Service record);

    int insertSelective(Service record);

    Service selectByPrimaryKey(Integer serviceid);

    int updateByPrimaryKeySelective(Service record);

    int updateByPrimaryKey(Service record);

    List<ServiceLinkUandM> findAll();

    HashMap<String, Object> findAllserviceByPage(int pageNum, int row);

    //模糊查询
    List<ServiceLinkUandM> selectByserviceName(String string);

    //根据serviceid查询服务信息
    List<ServiceLinkUandM> selectByserviceid(Integer serviceid);
}