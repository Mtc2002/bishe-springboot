package com.bishe.dataservice.service;

import com.bishe.api.model.User;
import com.bishe.api.service.UserService;
import com.bishe.common.util.CommonUtil;
import com.bishe.dataservice.mapper.UserMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@DubboService(interfaceClass = UserService.class,version = "1.0")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Value("lijiayaomengtianciadsfdafsafrerr")
    private String passwordSalt;
    @Override
    public User queryByPhone(String phone) {
        User user = null;
        if (CommonUtil.checkPhone(phone)) {
            user = userMapper.selectByPhone(phone);
        }
        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public synchronized int userRegister(String phone, String password) {
        int result = 0;//默认参数不正确
        if (CommonUtil.checkPhone(phone) && password !=null && password.length() == 32) {
            User queryUser = userMapper.selectByPhone(phone);
            if (queryUser == null) {
                //注册密码的md5二次加密。给原始密码加盐(salt)  eg:md5(123****)  =>md5( 123*****+ABC...)
                String newPassword = DigestUtils.md5Hex(password + passwordSalt);

                //注册u_user
                User user = new User();
                user.setPhone(phone);
                user.setLoginPassword(newPassword);
                userMapper.insertSelective(user);

                //成功:result = 1;
                result = 1;

            }else {
                //手机号存在
                result = 2;
            }
        }
        return result;
    }

    /*登录*/
    @Transactional(rollbackFor = Exception.class)
    @Override
    public User userLogin(String phone, String password) {
        User user = null ;
        if (CommonUtil.checkPhone(phone) && password !=null && password.length() == 32) {
            String newPassword = DigestUtils.md5Hex(password + passwordSalt);
            user = userMapper.selectLogin(phone,newPassword);

        }
        return user;
    }
}
