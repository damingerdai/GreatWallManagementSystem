package org.aming.gwms.exceptions;

import org.aming.gwms.logger.AmingLogger;
import org.aming.gwms.logger.LoggerManager;

/**
 * 自定义长城内部管理系统异常管理器
 * @author daming
 * @version 2017/6/22.
 */
public class ExceptionBuilder {

    /**
     * 内置的日志记录器
     */
    private static AmingLogger logger = LoggerManager.getLogger(ExceptionBuilder.class.getName());

    public static AmingException buildAmingException(String errorCode,Throwable cause){
        return null;
    }

}
