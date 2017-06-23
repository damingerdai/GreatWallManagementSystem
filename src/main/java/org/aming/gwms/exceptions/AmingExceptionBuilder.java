package org.aming.gwms.exceptions;

import org.aming.gwms.logger.AmingLogger;
import org.aming.gwms.logger.AmingLoggerManager;

/**
 * 自定义长城内部管理系统异常管理器
 * @author daming
 * @version 2017/6/22.
 */
public class AmingExceptionBuilder {

    /**
     * 内置的日志记录器
     */
    private static AmingLogger logger = AmingLoggerManager.getLogger(AmingExceptionBuilder.class.getName());

    public static AmingException buildAmingEzception(String errorCode,Throwable cause){
        return null;
    }

}
