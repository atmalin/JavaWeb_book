package com.atguigu.util;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * 把Map中的值注入到对应的JavaBean属性中。
 * @author malin
 * @create 2021-10-29-19:55
 * HttpServletRequest
 * Dao层
 * Service层
 * Web层 耦合度高
 */
public class WebUtils {

    public  static <T> T copyParamToBean(Map value, T bean){
        try {

            /**
             * 把所有请求的参数都注入到user对象中
             */
            System.out.println("注入之前：" + bean);
            BeanUtils.populate(bean,value);
            System.out.println("注入之后：" + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换称为int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}
