package com.bishe.common.util;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * Package:com.bishe.common.util
 */
public class CommonUtil {
    /*手机号格式  */
    public static boolean checkPhone(String phone){
        boolean flag = false;
        if (phone !=null && phone.length() == 11) {
            flag = Pattern.matches("^1[1-9]\\d{9}$", phone);
        }
        return flag;
    }


/*----------------------------分页处理、手机号脱敏(暂时用不上)---------------------------------------*/

    /*处理pageNo*/
    public static int defaultPageNo(Integer pageNo) {
        int pNo = pageNo;
        if (pageNo == null || pageNo < 1) {
            pNo = 1;
        }
        return pNo;
    }

    /*处理pageSize*/
    public static int defaultPageSize(Integer pageSize) {
        int pSize = pageSize;
        if (pageSize == null || pageSize < 1) {
            pSize = 1;
        }
        return pSize;
    }

    /*手机脱敏 131****9182*/
    public static String tuoMinPhone(String phone) {
        String result = "***********";
        if (phone != null && phone.trim().length() == 11) {
            result = phone.substring(0,3) + "******" + phone.substring(9,11);
        }
        return result;
    }
}
