package com.bishe.api.pojo;

import com.bishe.api.model.Patient;

import java.io.Serializable;
import java.util.List;

/**
 * package com.bishe.api.pojo;
 * Date:2024/4/25 13:31
 *全部养老人员信息
 * */
public class MultiPatient implements Serializable {
    private List<Patient> patient;

    public MultiPatient() {
    }

    public MultiPatient(List<Patient> patient) {
        this.patient = patient;
    }

    public List<Patient> getPatient() {
        return patient;
    }

    public void setPatient(List<Patient> patient) {
        this.patient = patient;
    }
}
