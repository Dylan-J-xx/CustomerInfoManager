package com.one.controller;

import com.one.model.Service;
import com.one.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.HashMap;

@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    ServiceService serviceService;

    //查询service所有内容 分页
    @GetMapping("/findAllserviceByPage")
    public HashMap<String, Object> findAllserviceByPage(int pageNum, int row) {
        return serviceService.findAllserviceByPage(pageNum, row);
    }

    //增加
    @GetMapping("/insert")
    public HashMap<String, Object> insertSelective(Service service) {
        return serviceService.insertSelective(service);
    }

    //删除
    @GetMapping("/delete")
    HashMap<String, Object> deleteByPrimaryKey(Integer serviceid) {
        return serviceService.deleteByPrimaryKey(serviceid);
    }

    //修改
    @GetMapping("/update")
    HashMap<String, Object> updateByPrimaryKeySelective(Service service) throws ParseException {
        return serviceService.updateByPrimaryKeySelective(service);
    }

    //模糊查询
    @GetMapping("/selectByserviceName")
    HashMap<String, Object> selectByserviceName(String serviceName) {
        return serviceService.selectByserviceName(serviceName);
    }

    //根据serviceId查询服务
    @GetMapping("/selectByserviceid")
    HashMap<String, Object> selectByserviceid(Integer serviceid) {
        return serviceService.selectByserviceid(serviceid);
    }
}
