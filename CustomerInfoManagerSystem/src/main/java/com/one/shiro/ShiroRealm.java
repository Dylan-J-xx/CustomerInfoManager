package com.one.shiro;

import com.one.mapper.ManagerInfoMapper;
import com.one.mapper.UserInfoMapper;
import com.one.model.ManagerInfo;
import com.one.model.UserInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {
    @Autowired(required = false)
    private UserInfoMapper userMapper;
    @Autowired(required = false)
    private ManagerInfoMapper managerinfoMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
        //判断身份
        String name = (String) token.getPrincipal();
        String decide = name.substring(0, 4);
        System.out.println("decide:" + decide);

        if ("isur".equals(decide)) {
            //1、获取用户的输入的账号
            String useraccount = name.substring(4, name.length());
            System.out.println("身份：" + useraccount);
            System.out.println("凭证：" + token.getCredentials());

            if (useraccount == null || useraccount.length() == 0) {
                return null;
            }
            //获取用户信息
            UserInfo user = userMapper.getStaffByUserName(useraccount);
            System.out.println("----》用户名查询：身份查询数据库对象！：" + user);

            if (user == null) {
                throw new UnknownAccountException(); //未知账号
            }
            //验证
            // 返回认证信息由父类AuthenticatingRealm进行认证
            authenticationInfo = new SimpleAuthenticationInfo(
                    user.getUseraccount(), //用户名
                    user.getUserpassword(), //密码
                    ByteSource.Util.bytes(user.getSalt()),//根据盐值加密
                    getName() //realm name
            );
            System.out.println(user.getSalt());
        } else if ("ismr".equals(decide)) {
            //1、获取用户的输入的账号
            String mangeraccount = name.substring(4, name.length());
            System.out.println("身份：" + mangeraccount);
            System.out.println("凭证：" + token.getCredentials());

            if (mangeraccount == null || mangeraccount.length() == 0) {
                return null;
            }
            //获取用户信息
            ManagerInfo manager = managerinfoMapper.getStaffByUserName(mangeraccount);
            System.out.println("----》用户名查询：身份查询数据库对象！：" + manager);

            if (manager == null) {
                throw new UnknownAccountException(); //未知账号
            }
            //验证
            // 返回认证信息由父类AuthenticatingRealm进行认证
            authenticationInfo = new SimpleAuthenticationInfo(
                    manager.getManagername(), //用户名
                    manager.getManagerpassword(), //密码
                    ByteSource.Util.bytes(manager.getSalt()),//根据盐值加密
                    getName() //realm name
            );
            System.out.println(manager.getSalt());
        }


        return authenticationInfo;
    }
}
