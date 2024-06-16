package com.bishe.api.service;

import com.bishe.api.model.Patient;
import com.bishe.api.pojo.MultiPatient;

import java.util.List;

public interface PatientService {

    /*查询全部养老人员信息*/

    MultiPatient queryAllPatient();

    /*按性别类型分页查询*/
    List<Patient> queryBySexLimt(Integer pType, Integer pageNo, Integer pageSize);


    /*根据用户名查询*/
    Patient queryByName(String name);

    /*新增用户*/
    Integer insertPatient(Patient patient);

    /*修改用户*/
    Integer upDataPatient(Patient patient);

    Integer deletePatient(Integer id);
}
