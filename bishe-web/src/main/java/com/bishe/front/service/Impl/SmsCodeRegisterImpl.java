package com.bishe.front.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.bishe.common.constants.RedisKey;
import com.bishe.front.config.JdwxSmsConfig;
import com.bishe.front.service.SmsService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service(value = "SmsCodeRegisterImpl")
public class SmsCodeRegisterImpl implements SmsService {

    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Resource
   private JdwxSmsConfig smsConfig;

    @Override
    public boolean sendSms(String phone) {
        boolean send = false;
        // 设置短信内容
        String random  = RandomStringUtils.randomNumeric(4);
        System.out.println("注册验证码的随机数 random="+random);
        //更新content中的  %s   【孟氏科技】你的验证码是：%s，3分钟内有效，请勿泄露给他人
        String content  = String.format(smsConfig.getContent(), random);

        //使用HttpClient发送 get 请求给第三方。
        CloseableHttpClient client = HttpClients.createDefault();
        //https://way.jd.com/chuangxin/dxjk?mobile=13568813957&content=【孟氏科技】你的验证码是：5873，3分钟内有效！&appkey=您申请的APPKEY
        String url = smsConfig.getUrl()+"?mobile="+phone
                +"&content=" + content
                +"&appkey="+smsConfig.getAppkey();
        HttpGet get  = new HttpGet(url);
        try{
            CloseableHttpResponse response = client.execute(get);
            if( response.getStatusLine().getStatusCode() == HttpStatus.SC_OK ){
                //得到返回的数据，json
                /*String text = EntityUtils.toString(response.getEntity());*/
                String text="{\n" +
                        "    \"code\": \"10000\",\n" +
                        "    \"charge\": false,\n" +
                        "    \"remain\": 1305,\n" +
                        "    \"msg\": \"查询成功\",\n" +
                        "    \"result\": {\n" +
                        "        \"ReturnStatus\": \"Success\",\n" +
                        "        \"Message\": \"ok\",\n" +
                        "        \"RemainPoint\": 420842,\n" +
                        "        \"TaskID\": 18424321,\n" +
                        "        \"SuccessCounts\": 1\n" +
                        "    }\n" +
                        "}";
                //解析json
                if(StringUtils.isNotBlank(text)){
                    // fastjson
                    JSONObject jsonObject = JSONObject.parseObject(text);
                    if("10000".equals(jsonObject.getString("code"))){ //第三方接口调用成功
                        //读取result中的key：ReturnStatus
                        if("Success".equalsIgnoreCase(
                                jsonObject.getJSONObject("result").getString("ReturnStatus"))){
                            //短信发送成功
                            send  = true;

                            //把短信验证码，存到redis
                            String key = RedisKey.KEY_SMS_CODE_REG + phone;
                            stringRedisTemplate.boundValueOps(key).set(random,3 , TimeUnit.MINUTES);

                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return send;
    }





    @Override
    public boolean checkSmsCode(String phone, String code) {
        String key = RedisKey.KEY_SMS_CODE_REG + phone;
        if (stringRedisTemplate.hasKey(key)) {
            String querySmsCode = stringRedisTemplate.boundValueOps(key).get();
            if (code.equalsIgnoreCase(querySmsCode)) {
                return true;
            }
        }
        return false;
    }
}
