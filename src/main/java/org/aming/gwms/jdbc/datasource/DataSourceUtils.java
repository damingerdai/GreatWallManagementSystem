package org.aming.gwms.jdbc.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.sql.DataSource;

import org.aming.gwms.constants.ErrorCodeConstants;
import org.aming.gwms.exceptions.AmingException;
import org.aming.gwms.exceptions.ExceptionBuilder;
import org.aming.gwms.utils.StringUtils;

/**
 * 数据源工具类
 * 参考spring-jdbc中的org.springframework.jdbc.datasource.DateSourceUtils类
 * @author daming
 *
 */
public abstract class DataSourceUtils {

	private static final String ERROR_GET_CONNECTION = "fail to get connection";
	private static final String ERROR_RELEASE_CONNECTION = "fail to release connection";
	
	private static ThreadLocal<Connection> localCache = new ThreadLocal<Connection>(); 
	
	public static Connection getConnection(DataSource dataSource) throws AmingException{
		try{
			return doGetConnection(dataSource);
		} catch(Exception ex){
			throw ExceptionBuilder.buildAmingException(ErrorCodeConstants.ERROR_CONNECTION,new String[]{ERROR_GET_CONNECTION,StringUtils.reflectionToString(dataSource)},ex);
		}
	}
	
	public static Connection doGetConnection(DataSource dataSource) throws SQLException{
		Connection conn = localCache.get();
		if(conn == null || conn.isClosed()){
			conn = newConnection(dataSource);
			localCache.set(conn);
		}
		return conn;	
	}
	
	private static Connection newConnection(DataSource dataSource) throws SQLException{
		Connection conn = dataSource.getConnection();
		if(conn == null){
			throw new IllegalStateException("DataSource returned null from getConnection(): " + dataSource);
		}
		return conn;
	}
	
	public static boolean releaseConnection(@Nullable Connection conn) throws AmingException{
		try{
			return doReleaseConnection(conn);
		}catch(Exception ex){
			throw ExceptionBuilder.buildAmingException(ErrorCodeConstants.ERROR_CONNECTION,new String[]{ERROR_RELEASE_CONNECTION,StringUtils.reflectionToString(conn)}, ex);
		}		
	}
	
	public static boolean doReleaseConnection(@Nullable Connection conn) throws SQLException{
		if(conn == null){
			return true;
		}
		if(!conn.getAutoCommit()){
			localCache.remove();
			return closeConnection(conn);
		}
		return false;
	}
	
	private static boolean closeConnection(@Nonnull Connection conn) throws SQLException{
		conn.close();
		if(conn.isClosed()){
			return true;
		}
		return false;
	}
}
