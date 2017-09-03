package org.aming.gwms.utils;

import java.io.IOException;
import java.util.Properties;

import org.aming.gwms.logger.LoggerManager;

/**
 * 配置文件加载工具类
 * @author daming
 * @version 2017/7/4.
 */
public class PropertyLoader {
    
    private Properties prop;
    
    private PropertyLoader(){
    	prop = new Properties();
    }
    
    private PropertyLoader(String...fileNames){
        this();
        init(fileNames);
    }
    
    public String getProperty(String key){
        return prop.getProperty(key);
    }

    public String getProperty(String key,String defaultValue){
        return prop.getProperty(key,defaultValue);
    }

    public Object getValue(Object key){
        return prop.get(key);
    }

    public static PropertyLoader getInstance(String...fileName) {
        return new PropertyLoader(fileName);
    }

    private void init(String...properties){
    	for(String fileName:properties){
    		try{
                prop.load(PropertyLoader.class.getResourceAsStream(fileName));
            }catch (IOException e){
                LoggerManager.getErrorLogger().error("fail to init {} porperties. error message : {}",fileName,e.getMessage());
            }
    	}
    }
}
