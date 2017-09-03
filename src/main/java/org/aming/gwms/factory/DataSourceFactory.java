package org.aming.gwms.factory;

import javax.sql.DataSource;

import org.aming.gwms.exceptions.Exceptions;
import org.aming.gwms.utils.PropertyLoader;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceFactory {
	
	private static DataSource dataSource;
	
	public static DataSource newDataSource(){
		try{
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			PropertyLoader propertyLoader = PropertyLoader.getInstance("/jdbc.properties");
			dataSource.setDriverClass(propertyLoader.getProperty("driver"));
			return dataSource;
		} catch(Exception e){
			throw Exceptions.toRuntimeException(e);
		}	
	}
	
	public static DataSource getDataSource(){
		if(dataSource == null){
			dataSource = newDataSource();
		}
		return dataSource;
	}
}
