package com.one.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.one.mapper.ServiceMapper;
import com.one.model.ServiceLinkUandM;
import com.one.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceMapper serviceMapper;


    //查询service及其连接表的内容，分页显示
    @Override
    public HashMap<String, Object> findAllserviceByPage(int pageNum, int row) {
        HashMap<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum, row);
        List<ServiceLinkUandM> list = serviceMapper.findAll();
        PageInfo<ServiceLinkUandM> page = new PageInfo<>(list);


        map.put("pages", page.getPages());
        map.put("total", page.getTotal());
        map.put("curpage", page.getPrePage() + 1);
        map.put("list", page.getList());

        return map;
    }

    //增加
    @Override
    public HashMap<String, Object> insertSelective(com.one.model.Service service) {
        HashMap<String, Object> map = new HashMap<>();
        Date day = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = sdf.format(day);
        try {
            day = sdf.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(day);
        service.setDate(day);
        int i = serviceMapper.insert(service);
        if (i != 0) {
            map.put("info", "插入成功");
        } else {
            map.put("info", "插入失败");
        }

        return map;
    }

    //删除
    @Override
    public HashMap<String, Object> deleteByPrimaryKey(Integer serviceid) {
        HashMap<String, Object> map = new HashMap<>();
        int i = serviceMapper.deleteByPrimaryKey(serviceid);
        if (i != 0) {
            map.put("info", "删除成功");
        } else {
            map.put("info", "删除失败");
        }

        return map;
    }

    //修改
    @Override
    public HashMap<String, Object> updateByPrimaryKeySelective(com.one.model.Service service) throws ParseException {
        HashMap<String, Object> map = new HashMap<>();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(date);
        date = sdf.parse(time);
        service.setDate(date);
        int i = serviceMapper.updateByPrimaryKeySelective(service);

        if (i != 0) {
            map.put("info", "修改成功");
        } else {
            map.put("info", "修改失败");
        }
        return map;
    }


    @Override
    public HashMap<String, Object> selectByserviceName(String string) {
        HashMap<String, Object> map = new HashMap<>();
        List<ServiceLinkUandM> list = serviceMapper.selectByserviceName(string);
        if (list != null) {
            map.put("info", list);
        } else {
            map.put("info", "查询失败");
        }

        return map;
    }

    @Override
    public HashMap<String, Object> selectByserviceid(Integer serviceid) {
        HashMap<String, Object> map = new HashMap<>();
        List<ServiceLinkUandM> list = serviceMapper.selectByserviceid(serviceid);
        if (list != null) {
            map.put("info", list);
        } else {
            map.put("info", null);
        }

        return map;
    }


}
