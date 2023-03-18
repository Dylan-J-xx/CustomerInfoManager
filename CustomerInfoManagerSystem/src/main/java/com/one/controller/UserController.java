package com.one.controller;

import com.one.model.UserInfo;
import com.one.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    //分页
    @GetMapping("/findAllUserByPage")
    public HashMap<String, Object> findAllUserByPage(Integer pageNum, Integer row) {
        return userService.findAllUserByPage(pageNum, row);
    }

    //删除
    @GetMapping("/del")
    public HashMap<String, Object> deleteByPrimaryKey(Integer userId) {
        return userService.deleteByPrimaryKey(userId);
    }

    //添加
    @GetMapping("/add")
    HashMap<String, Object> insert(UserInfo userInfo) {
        HashMap<String, Object> map = new HashMap<>();
        if (userInfo.getUserpassword() != null) {
            return userService.insert(userInfo);
        } else {
            map.put("info", "密码为空");
            return map;
        }
    }

    //修改
    @GetMapping("/update")
    public HashMap<String, Object> update(UserInfo userInfo) {
        HashMap<String, Object> map = new HashMap<>();
        if (userInfo.getUserid() != null) {
            return userService.update(userInfo);
        } else {
            map.put("info", "id为空");
            return map;
        }
    }

    //查找指定用户的所有信息
    @GetMapping("/selectById")
    public HashMap<String, Object> selectById(Integer userid) {
        return userService.selectByPrimaryKey(userid);
    }

    //模糊查询
    @GetMapping("/selectByuserName")
    public HashMap<String, Object> selectByuserName(String userName) {
        return userService.selectByuserName(userName);
    }

    //分页查找指定联系人
    @GetMapping("/findAllManagerUserByPage")
    public HashMap<String, Object> findAllManagerUserByPage(int pageNum, int row, String managerName) {
        return userService.findAllManagerUserByPage(pageNum, row, managerName);
    }

}
