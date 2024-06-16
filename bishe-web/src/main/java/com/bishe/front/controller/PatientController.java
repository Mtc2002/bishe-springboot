package com.bishe.front.controller;

import com.bishe.api.model.Patient;
import com.bishe.api.pojo.MultiPatient;
import com.bishe.front.service.Impl.view.RespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


@Api(tags = "主视图养老人员信息功能")
@RestController
@RequestMapping("/v1")
public class PatientController extends BaseController{

    /*平台基本信息*/
    @ApiOperation(value = "养老人员基本信息",notes = "养老人员信息")
    /*登录基本信息*/
    @GetMapping("/patient/info")
    public RespResult queryAllPatient(){
        //调用远程服务
        RespResult result = new RespResult();
        MultiPatient multiPatient = patientService.queryAllPatient();
        result.setCode(1000);
        result.setMsg("查询平台信息成功");
        result.setData(multiPatient);
        return result;
    }
    /*搜寻姓名定位病人位置*/
    @PostMapping("/patient/lat")
    @ApiOperation(value = "搜寻定位",notes = "养老人员经纬度信息")
    public RespResult queryByName(@RequestParam String name){
        RespResult result = new RespResult();
        Patient patient = patientService.queryByName(name);
        result.setCode(1000);
        result.setMsg("查询信息成功");
        result.setData(patient);
        return result;

    }

    @ApiOperation(value = "养老人员信息添加")
    @PostMapping("/patient/insert")
    public RespResult insertPatient(Patient patient){
        RespResult result = new RespResult();
        Integer integer = patientService.insertPatient(patient);
        result.setCode(1000);
        result.setMsg("添加信息成功");
        result.setData(patient);
        return result;
    }


    @ApiOperation(value = "养老人员信息修改")
    @PostMapping("/patient/upData")
    public RespResult upDataPatient(Patient patient){
        RespResult result = new RespResult();
        Integer integer = patientService.upDataPatient(patient);
        result.setCode(1000);
        result.setMsg("修改信息成功");
        result.setData(patient);
        return result;
    }

    @ApiOperation(value = "养老人员信息删除")
    @PostMapping("/patient/delete")
    public RespResult deletePatient(Integer id){
        RespResult result = new RespResult();
        Integer integer = patientService.deletePatient(id);
        result.setCode(1000);
        result.setMsg("删除信息成功");
        return result;
    }


}
