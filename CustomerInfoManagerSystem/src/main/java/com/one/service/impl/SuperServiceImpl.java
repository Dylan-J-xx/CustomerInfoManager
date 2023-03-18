package com.one.service.Impl;

import com.one.mapper.SuperadminMapper;

import com.one.model.Superadmin;
import com.one.service.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class SuperServiceImpl implements SuperService {
    @Autowired
    SuperadminMapper superadminMapper;

    //登录
    @Override
    public HashMap<String, Object> login(Superadmin superadmin) {
        HashMap<String, Object> map = new HashMap<>();
        Superadmin sa = superadminMapper.selectbyaccount(superadmin.getSuperadminaccount().substring(4, superadmin.getSuperadminaccount().length()));
        superadmin.setSuperadminaccount(superadmin.getSuperadminaccount().substring(4, superadmin.getSuperadminaccount().length()));
        System.out.println(superadmin.getSuperadminaccount());
        Superadmin superadmin1 = superadminMapper.login(superadmin);
        if (superadmin1 != null) {
            map.put("data", sa);
            map.put("info", "管理员登录成功");
        } else {
            map.put("info", "管理员查无此人");
        }
        return map;
    }

}
