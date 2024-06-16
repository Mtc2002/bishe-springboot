package com.bishe.api.service;

import com.bishe.api.model.User;

public interface UserService {

    /*根据手机号查询*/
    User queryByPhone(String phone);

    /*用户注册*/
    int userRegister(String phone, String password);

    /*用户登录*/
    User userLogin(String phone, String pword);


}
