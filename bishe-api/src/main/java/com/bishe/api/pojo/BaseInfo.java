package com.bishe.api.pojo;

import java.io.Serializable;
/*implements Serializable因为需要传给Web 序列化保证传输效率*/
public class BaseInfo implements Serializable {
    /*注册人数*/
    private Integer registerUsers;


    public BaseInfo() {
    }

    public BaseInfo(Integer registerUsers) {
        this.registerUsers = registerUsers;
    }


    public Integer getRegisterUsers() {
        return registerUsers;
    }


    public void setRegisterUsers(Integer registerUsers) {
        this.registerUsers = registerUsers;
    }
}
