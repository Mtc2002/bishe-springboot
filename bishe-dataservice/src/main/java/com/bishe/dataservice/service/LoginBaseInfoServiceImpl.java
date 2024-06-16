package com.bishe.dataservice.service;


import com.bishe.api.pojo.BaseInfo;
import com.bishe.api.service.LoginBaseInfoService;
import com.bishe.dataservice.mapper.PatientMapper;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService(interfaceClass = LoginBaseInfoService.class,version = "1.0")
public class LoginBaseInfoServiceImpl implements LoginBaseInfoService {
    //注入Mapper
    @Resource
    private PatientMapper patientMapper;

    /*登陆页面信息*/
    @Override
    public BaseInfo queryLoginBaseInfo() {
        /*注册人数，账号密码，手机号*/
        int registerUser = patientMapper.selectCountPatient();

        BaseInfo baseInfo = new BaseInfo(registerUser);

        return baseInfo;
    }
}
