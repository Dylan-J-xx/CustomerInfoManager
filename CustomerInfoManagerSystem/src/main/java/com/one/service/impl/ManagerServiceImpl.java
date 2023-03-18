package com.one.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.one.mapper.ManagerInfoMapper;
import com.one.model.ManagerInfo;
import com.one.service.ManagerService;
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
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerInfoMapper managerinfoMapper;

    @Override
    public HashMap<String, Object> login(ManagerInfo managerinfo) {
        HashMap<String, Object> map = new HashMap<>();
        ManagerInfo manager = managerinfoMapper.selectbyaccount(managerinfo.getManageraccount().substring(4, managerinfo.getManageraccount().length()));

        //        生成认证对象
        AuthenticationToken token = new UsernamePasswordToken(managerinfo.getManageraccount(), managerinfo.getManagerpassword());
        Subject subject = SecurityUtils.getSubject();

//        调用shiro的登录方法
        try {
            subject.login(token);
            map.put("data", manager);
            map.put("info", "客户经理登录成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("info", "客户经理查无此人");
        }

        return map;
    }

    //客户信息分页查询
    public HashMap<String, Object> findAllManagerByPage(Integer pageNum, Integer row) {
        System.out.println(pageNum + "..." + row);
        HashMap<String, Object> map = new HashMap<>();

        PageHelper.startPage(pageNum, row);

        List<ManagerInfo> list = managerinfoMapper.findAll();

        PageInfo<ManagerInfo> page = new PageInfo<>(list);
        //得到结果集
        map.put("managerList", page.getList());
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
    public HashMap<String, Object> deleteByPrimaryKey(Integer managerid) {
        HashMap<String, Object> map = new HashMap<>();
        int i = managerinfoMapper.deleteByPrimaryKey(managerid);
        if (i != 0) {
            map.put("info", "删除成功");
        } else {
            map.put("info", "删除失败");
        }
        return map;
    }


    //添加
    @Override
    public HashMap<String, Object> insert(ManagerInfo managerInfo) {
        HashMap<String, Object> map = new HashMap<>();
        //随机生成account编号并判断不重复
        Random random = new Random();
        int accountnum = random.nextInt();
        while (accountnum <= 0) {
            accountnum = random.nextInt();
        }
        String account = "A" + accountnum;
        List<ManagerInfo> list = managerinfoMapper.findAll();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ManagerInfo manager = (ManagerInfo) it.next();
            if (account.equals(manager.getManageraccount())) {
                account = "A" + (Integer.valueOf(account.substring(1, account.length())) + 1);
            }
        }
        //将生成的account插入
        managerInfo.setManageraccount(account);

        //密码进行盐值加密
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        System.out.println("盐值:" + salt);
        String SimpleHash = new SimpleHash("MD5", managerInfo.getManagerpassword(), salt, 2).toString();
        managerInfo.setManagerpassword(SimpleHash);
        managerInfo.setSalt(salt);

        int i = managerinfoMapper.insert(managerInfo);
        if (i != 0) {
            map.put("info", account);
        } else {
            map.put("info", "有空值数据");
        }
        return map;
    }

    //修改
    @Override
    public HashMap<String, Object> update(ManagerInfo managerInfo) {
        HashMap<String, Object> map = new HashMap<>();
        //设置第二个键值account等于原值
        ManagerInfo manager = managerinfoMapper.selectByPrimaryKey(managerInfo.getManagerid());
        managerInfo.setManageraccount(manager.getManageraccount());
        //如果更改了密码 则再加密
        if (managerInfo.getManagerpassword() != null) {
            String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
            String SimpleHash = new SimpleHash("MD5", managerInfo.getManagerpassword(), salt, 2).toString();
            managerInfo.setSalt(salt);
            managerInfo.setManagerpassword(SimpleHash);
        }
        int i = managerinfoMapper.updateByPrimaryKeySelective(managerInfo);
        if (i != 0) {
            map.put("info", "修改成功");
        } else {
            map.put("info", "错误");
        }

        return map;
    }

    //指定查询某个用户
    @Override
    public HashMap<String, Object> selectByPrimaryKey(Integer managerid) {
        HashMap<String, Object> map = new HashMap<>();
        ManagerInfo managerInfo = managerinfoMapper.selectByPrimaryKey(managerid);
        System.out.println(managerid);
        if (managerInfo != null) {
            map.put("info", managerInfo);
        } else {
            map.put("info", "查询为空");
        }

        return map;
    }

    //模糊查询
    @Override
    public HashMap<String, Object> selectBymanagerName(String string) {
        HashMap<String, Object> map = new HashMap<>();
        List<ManagerInfo> list = managerinfoMapper.selectBymanagerName(string);
        if (list != null) {
            map.put("info", list);
        } else {
            map.put("info", "查询失败");
        }

        return map;
    }
}
