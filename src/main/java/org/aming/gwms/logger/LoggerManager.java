package org.aming.gwms.logger;

import com.google.common.collect.Maps;

import org.aming.gwms.constants.Constants;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 自定义长城内部管理系统的日志管理工厂
 * @author daming
 * @version 2017/6/22.
 */
public class LoggerManager {
    /**
     * 按照日志记录器的名字存放不同日志记录器的集合
     */
    private static Map<String,AmingLogger> loggerMap = Maps.newHashMap();

    /**
     * 根据日志记录器的名字返回相应的日志记录器
     * 如果
     * @param loggerName
     * @return
     */
    public static AmingLogger getLogger(String loggerName){
        if(!loggerMap.containsKey(loggerName)){
            loggerMap.put(loggerName,new AmingLogger(LoggerFactory.getLogger(loggerName)));
        }
        return loggerMap.get(loggerName);
    }
    
    public static AmingLogger getErrorLogger(){
    	return getLogger(Constants.LOG_ERROR);
    }
}
