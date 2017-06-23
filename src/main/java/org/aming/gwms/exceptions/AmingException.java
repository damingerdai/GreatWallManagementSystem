package org.aming.gwms.exceptions;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 自定义长城内部管理系统异常
 * @author daming
 * @version 2017/6/22.
 */
public class AmingException extends RuntimeException {

    /**
     * 异常代码
     */
    private String errorCode;

    /**
     * 异常信息
     */
    private String errorMsg;

    /**
     * 异常错误
     */
    private Throwable cause;

    /**
     * 初始化
     * @param errorCode
     * @param errorMsg
     * @param cause
     */
    public AmingException(String errorCode,String errorMsg,Throwable cause){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.cause = cause;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
