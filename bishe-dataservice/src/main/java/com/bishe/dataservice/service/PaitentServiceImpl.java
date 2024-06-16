package com.bishe.dataservice.service;

import com.bishe.api.model.Patient;
import com.bishe.api.pojo.MultiPatient;
import com.bishe.api.service.PatientService;
import com.bishe.dataservice.mapper.PatientMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@DubboService(interfaceClass = PatientService.class,version = "1.0")
public class PaitentServiceImpl implements PatientService {

    @Resource
    private PatientMapper patientMapper;

    /*养老人员全部信息*/
    @Override
    public MultiPatient queryAllPatient() {
        MultiPatient result = new MultiPatient();

        List<Patient> patients = patientMapper.selectAllPatient();

        result.setPatient(patients);
        return result;
    }

    /*按性别分页查询*/
    @Override
    public List<Patient> queryBySexLimt(Integer pType, Integer pageNo, Integer pageSize) {
        return null;
    }

    @Override
    public Patient queryByName(String name) {
        Patient patient = null;
            patient = patientMapper.selectByName(name);
        return patient;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer insertPatient(Patient patient) {
        Integer integer = null;
        integer = patientMapper.insert(patient);
        return integer;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer upDataPatient(Patient patient) {
        Integer integer = null;
        integer = patientMapper.updateByPrimaryKeySelective(patient);
        return integer;
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer deletePatient(Integer id) {
        Integer integer = null;
        integer = patientMapper.deleteByPrimaryKey(id);
        return integer;
    }
}
