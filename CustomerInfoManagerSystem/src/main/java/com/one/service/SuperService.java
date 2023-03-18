package com.one.service;

import com.one.model.Superadmin;

import java.util.HashMap;

public interface SuperService {
    //登录
    HashMap<String, Object> login(Superadmin superadmin);

}
