package com.soft1851.spring.boot.aop.util;

import java.text.DecimalFormat;

/**
 * @author wl
 * @ClassNameCommonUtil
 * @Description TODO
 * @Date 2020/2/1
 * @Version 1.0
 */
public class CommonUtil {
    public static String CountPrograss(double molecule, double Denominator) {
        //保留小数点后两位
        DecimalFormat decimalFormat =new DecimalFormat("0.00");
        String result =decimalFormat.format( (molecule/Denominator)*100)+"%";

        // 结果是81.25% ，最后一们四舍五入了
        return result;
    }

    public  static double CountStage(String str) {
        Integer count = 0;
        char[] e = str.toCharArray();
        for (int i = 0; i < e.length; i++) {
            if (e[i] >= '0' && e[i] <= '9') {
                count++;
            }
        }
        return  count;
    }

    public static void main(String[] args) {
        System.out.println(      CountPrograss(2,2));

    }

}
