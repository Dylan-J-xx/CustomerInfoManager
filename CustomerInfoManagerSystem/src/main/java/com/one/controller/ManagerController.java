package com.one.controller;

import com.one.model.ManagerInfo;
import com.one.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    //分页
    @GetMapping("/findAllManagerByPage")
    public HashMap<String, Object> findAllManagerByPage(Integer pageNum, Integer row) {
        return managerService.findAllManagerByPage(pageNum, row);
    }

    //删除
    @GetMapping("/del")
    public HashMap<String, Object> deleteByPrimaryKey(Integer managerId) {
        return managerService.deleteByPrimaryKey(managerId);
    }

    //添加
    @GetMapping("/add")
    HashMap<String, Object> insert(ManagerInfo managerInfo) {
        HashMap<String, Object> map = new HashMap<>();
        if (managerInfo.getManagerpassword() != null) {
            return managerService.insert(managerInfo);
        } else {
            map.put("info", "密码为空");
            return map;
        }
    }

    //修改
    @GetMapping("/update")
    public HashMap<String, Object> update(ManagerInfo managerInfo) {
        HashMap<String, Object> map = new HashMap<>();
        if (managerInfo.getManagerid() != null) {
            return managerService.update(managerInfo);
        } else {
            map.put("info", "id不能为空");
            return map;
        }

    }

    //查找指定用户的所有信息
    @GetMapping("/selectById")
    public HashMap<String, Object> selectById(Integer managerid) {
        return managerService.selectByPrimaryKey(managerid);
    }

    //模糊查询
    @GetMapping("/selectBymanagerName")
    public HashMap<String, Object> selectBymanagerName(String managerName) {
        return managerService.selectBymanagerName(managerName);
    }

}
