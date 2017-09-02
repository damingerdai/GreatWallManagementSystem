package org.aming.gwms.utils;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 自定义字符串工具类
 * @author daming
 * @version 2017/6/22.
 */
public class StringUtils extends org.apache.commons.lang.StringUtils {

    /**
     * 将对象转为String类型
     * @param obj
     * @return
     */
    public static String reflectionToString (Object obj){
        return ToStringBuilder.reflectionToString(obj);
    }
}