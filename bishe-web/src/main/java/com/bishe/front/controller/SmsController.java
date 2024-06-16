package com.bishe.front.controller;


import com.bishe.common.constants.RedisKey;
import com.bishe.common.enums.RCode;
import com.bishe.common.util.CommonUtil;
import com.bishe.front.service.Impl.view.RespResult;
import com.bishe.front.service.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(tags = "短信业务")
@RestController
@RequestMapping("/v1/sms")
public class SmsController extends BaseController{

    @Resource
    private SmsService smsService;

    @ApiOperation(value = "注册验证码短信")
    @GetMapping("/code/register")
    public RespResult sendCodeRegister(@RequestParam String phone){
        RespResult result = RespResult.fail();
        if (CommonUtil.checkPhone(phone)) {
            //判断redis中是否有该手机号的验证码
            String key = RedisKey.KEY_SMS_CODE_LOGIN + phone;
            if (stringRedisTemplate.hasKey(key)) {
                result = RespResult.ok();
                result.setRCode(RCode.SMS_CODE_CAN_USE);
            }else {
                boolean isSuccess = smsService.sendSms(phone);
                if (isSuccess) {
                    result = RespResult.ok();
                }
            }

        }else {
            result.setRCode(RCode.PHONE_FORMAT_ERR);
        }
        return result;
    }
}
