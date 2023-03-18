package com.one.controller;

import com.one.model.ManagerInfo;
import com.one.model.Superadmin;
import com.one.model.UserInfo;
import com.one.service.ManagerService;
import com.one.service.SuperService;
import com.one.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("")
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    ManagerService managerService;
    @Autowired
    SuperService superService;

    @GetMapping("/login")
    public HashMap<String, Object> login(String account, String password) {
        String decide = account.substring(0, 1);
        System.out.println(decide);
        if ("A".equals(decide)) {
            ManagerInfo managerinfo = new ManagerInfo();
            managerinfo.setManageraccount("ismr" + account);
            managerinfo.setManagerpassword(password);
            return managerService.login(managerinfo);
        } else if ("B".equals(decide)) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUseraccount("isur" + account);
            userInfo.setUserpassword(password);
            return userService.login(userInfo);
        } else if ("S".equals(decide)) {
            Superadmin superadmin = new Superadmin();
            superadmin.setSuperadminaccount("issr" + account);
            superadmin.setSuperadminpassword(password);
            return superService.login(superadmin);
        } else {
            HashMap<String, Object> map = new HashMap<>();
            map.put("info", "输入错误");
            return map;
        }
    }
}
