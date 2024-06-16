package com.bishe.front.controller;

import com.bishe.api.service.LoginBaseInfoService;
import com.bishe.api.service.PatientService;
import com.bishe.api.service.UserService;
import com.bishe.front.service.SmsService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

public class BaseController {

    //声明公共的方法，属性等

    @Resource
    protected StringRedisTemplate stringRedisTemplate;

    @DubboReference(interfaceClass = LoginBaseInfoService.class,version = "1.0")
    protected LoginBaseInfoService loginBaseInfoService;

    @DubboReference(interfaceClass = PatientService.class,version = "1.0")
    protected PatientService patientService;

    //用户服务
    @DubboReference(interfaceClass = UserService.class,version = "1.0")
    protected UserService userService;

}
