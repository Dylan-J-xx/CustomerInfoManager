package com.one.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.one.mapper.UserInfoMapper;
import com.one.model.UserInfo;
import com.one.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserInfoMapper userInfoMapper;

    //客户登录
    @Override
    public HashMap<String, Object> login(UserInfo userInfo) {
        HashMap<String, Object> map = new HashMap<>();
        UserInfo user = userInfoMapper.selectbyaccount(userInfo.getUseraccount().substring(4, userInfo.getUseraccount().length()));
        //        生成认证对象
        AuthenticationToken token = new UsernamePasswordToken(userInfo.getUseraccount(), userInfo.getUserpassword());
        Subject subject = SecurityUtils.getSubject();
//        调用shiro的登录方法
        try {
            subject.login(token);
            map.put("info", "客户登录成功");
            map.put("data", user);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("info", "客户查无此人");
        }

        return map;
    }

    //客户信息分页查询
    public HashMap<String, Object> findAllUserByPage(Integer pageNum, Integer row) {
        HashMap<String, Object> map = new HashMap<>();

        PageHelper.startPage(pageNum, row);

        List<UserInfo> list = userInfoMapper.findAll();

        PageInfo<UserInfo> page = new PageInfo<>(list);
        //得到结果集
        map.put("userList", page.getList());
        //得到当前页
        map.put("curPage", page.getPrePage() + 1);
        //总条数
        map.put("total", page.getTotal());
        //总页数
        map.put("pages", page.getPages());


        return map;
    }

    //删除
    @Override
    public HashMap<String, Object> deleteByPrimaryKey(Integer userid) {
        HashMap<String, Object> map = new HashMap<>();
        int i = userInfoMapper.deleteByPrimaryKey(userid);
        if (i != 0) {
            map.put("info", "删除成功");
        } else {
            map.put("info", "删除失败");
        }
        return map;
    }


    //添加
    @Override
    public HashMap<String, Object> insert(UserInfo userInfo) {
        HashMap<String, Object> map = new HashMap<>();
        //随机生成account编号并判断不重复
        Random random = new Random();
        int accountnum = random.nextInt();
        while (accountnum <= 0) {
            accountnum = random.nextInt();
        }
        String account = "B" + accountnum;
        List<UserInfo> list = userInfoMapper.findAll();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            UserInfo user = (UserInfo) it.next();
            if (account.equals(user.getUseraccount())) {
                account = "B" + (Integer.valueOf(account.substring(1, account.length())) + 1);
            }
        }
        //将生成的account插入
        userInfo.setUseraccount(account);

        //密码进行盐值加密
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        System.out.println("盐值:" + salt);
        String SimpleHash = new SimpleHash("MD5", userInfo.getUserpassword(), salt, 2).toString();
        userInfo.setUserpassword(SimpleHash);
        userInfo.setSalt(salt);

        int i = userInfoMapper.insert(userInfo);
        if (i != 0) {
            map.put("info", account);
        } else {
            map.put("info", "有空值数据");
        }
        return map;
    }

    //修改
    @Override
    public HashMap<String, Object> update(UserInfo userInfo) {
        HashMap<String, Object> map = new HashMap<>();
        //设置第二个键值account等于原值
        UserInfo user = userInfoMapper.selectByPrimaryKey(userInfo.getUserid());
        userInfo.setUseraccount(user.getUseraccount());
        //如果更改了密码 则再加密
        if (userInfo.getUserpassword() != null) {
            String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
            String SimpleHash = new SimpleHash("MD5", userInfo.getUserpassword(), salt, 2).toString();
            userInfo.setSalt(salt);
            userInfo.setUserpassword(SimpleHash);
        }

        int i = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        if (i != 0) {
            map.put("info", "修改成功");
        } else {
            map.put("info", "错误");
        }

        return map;
    }

    //指定查询某个用户
    @Override
    public HashMap<String, Object> selectByPrimaryKey(Integer userid) {
        HashMap<String, Object> map = new HashMap<>();
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userid);
        System.out.println(userid);
        if (userInfo != null) {
            map.put("info", userInfo);
        } else {
            map.put("info", "查询为空");
        }

        return map;
    }

    //模糊查询
    @Override
    public HashMap<String, Object> selectByuserName(String string) {
        HashMap<String, Object> map = new HashMap<>();
        List<UserInfo> list = userInfoMapper.selectByuserName(string);
        if (list != null) {
            map.put("info", list);
        } else {
            map.put("info", "查询失败");
        }

        return map;
    }

    //分页查找指定联系人
    @Override
    public HashMap<String, Object> findAllManagerUserByPage(int pageNum, int row, String managerName) {
        HashMap<String, Object> map = new HashMap<>();

        PageHelper.startPage(pageNum, row);
        List<UserInfo> list = userInfoMapper.selectBymanagerName(managerName);
        PageInfo<UserInfo> page = new PageInfo<>(list);

        map.put("pages", page.getPages());
        map.put("curpage", page.getPrePage() + 1);
        map.put("total", page.getTotal());
        map.put("userList", page.getList());


        return map;
    }


}
