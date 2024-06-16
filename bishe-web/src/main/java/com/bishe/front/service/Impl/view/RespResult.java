package com.bishe.front.service.Impl.view;

import com.bishe.common.enums.RCode;

import java.util.List;

/**
 * Package:com.bishe.front.view
 * 同一的应答结果。 controller方法的返回值都是它
 */
public class RespResult {
    //应答码，自定义的数字
    private int code;
    //code的文字说明，一般做提示给用户看
    private String msg;

    //访问系统token
    private String accessToken;
    //单个数据
    private Object data;

    //集合数据
    private List list;

    //表示成功的RespResult对象
    public static RespResult ok(){
        RespResult result = new RespResult();
        result.setRCode(RCode.SUCC);
        return result;
    }
    //表示失败的RespResult对象
    public static RespResult fail(){
        RespResult result = new RespResult();
        result.setRCode(RCode.UNKOWN);
        return result;
    }

    public void setRCode(RCode rcode){
        this.code = rcode.getCode();
        this.msg = rcode.getText();
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
