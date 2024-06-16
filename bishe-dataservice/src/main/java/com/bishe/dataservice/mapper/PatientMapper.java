package com.bishe.dataservice.mapper;

import com.bishe.api.model.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientMapper {
    /*统计养老注册人数*/
    int selectCountPatient();
    /*查询所有养老人员信息*/
    List<Patient> selectAllPatient();


    /*按性别类型分页查询*/

    int deleteByPrimaryKey(Integer id);

    int insert(Patient record);

    int insertSelective(Patient record);

    Patient selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);

    Patient selectByName(@Param("name") String name);
}
