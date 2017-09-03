package org.aming.gwms.config;

import java.util.Map;

import org.aming.gwms.utils.PropertyLoader;
import org.aming.gwms.utils.StringUtils;

import com.google.common.collect.Maps;

/**
 * 全局管理器
 * @author daming
 * @version 2017/6/22.
 */
public class Global {
	private static final PropertyLoader propertyLoader = PropertyLoader.getInstance("/application.peroperties");
	
	private static final Map<String,Object> encahe = Maps.newHashMap();
	
	public static String getProperty(String key){
		if(encahe.containsKey(key)){
			encahe.put(key, propertyLoader.getValue(key));
		}
		return String.valueOf(encahe.get(key));
	}
	
	public static String getProperty(String key,String defaultValue){
		String property = getProperty(key);
		if(property == null){
			return defaultValue;
		}
		return property;
	}

}
