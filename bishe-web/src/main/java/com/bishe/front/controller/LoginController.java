package com.bishe.front.controller;

import com.bishe.api.pojo.BaseInfo;
import com.bishe.front.service.Impl.view.RespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "登录平台信息功能")
@RestController
@RequestMapping("/v1")
public class LoginController extends BaseController{

    /*平台基本信息*/
    @ApiOperation(value = "平台基本信息",notes = "养老人员注册人数")
    /*登录基本信息*/
    @GetMapping("/login/info")
    public RespResult queryLoginBaseInfo(){
        //调用远程服务
        BaseInfo baseInfo = loginBaseInfoService.queryLoginBaseInfo();
        RespResult result = new RespResult();

        result.setCode(1000);
        result.setMsg("查询平台信息成功");
        result.setData(baseInfo);

        return result;
    }
}
