package com.bishe.front.service;

public interface SmsService {

    //发送短信

    /**
     *
     * @param phone  手机号
     * @return true 成功
     */
    boolean sendSms(String phone);

    /**
     *
     * @param phone
     * @param code 提交参数中的验证码
     * @return
     */
    boolean checkSmsCode(String phone, String code);
}
