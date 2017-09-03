package org.aming.gwms.exceptions;

import org.aming.gwms.config.Global;
import org.aming.gwms.constants.Constants;
import org.aming.gwms.logger.AmingLogger;
import org.aming.gwms.logger.LoggerManager;
import org.aming.gwms.utils.StringUtils;

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
        return buildAmingException(errorCode,null,cause);
    }
    
    public static AmingException buildAmingException(String errorCode,String[] parameters,Throwable cause){
    	String errorMsg = Global.getProperty(errorCode);
    	if(parameters != null && parameters.length < 1){
    		errorMsg = StringUtils.replace(Constants.ERROR_REPLACE_PREFIX,Constants.ERROR_REPLACE_SUFFIX,errorMsg,parameters);
    	}
        return new AmingException(errorCode,errorMsg,cause);
    }

}
