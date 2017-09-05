package org.aming.gwms.logger;

import org.slf4j.Logger;

/**
 * 自定义长城内部管理系统的日志记录器
 * 
 * @author daming
 * @version 2017/6/22.
 */
public class AmingLogger {

	/**
	 * 默认的日志记录器
	 */
	private Logger logger;

	/**
	 * 初始化
	 * 
	 * @param logger
	 */
	public AmingLogger(Logger logger) {
		this.logger = logger;
	}

	/**
	 * 如果默认的日志管理器支持追踪信息<br/>
	 * 则追踪信息
	 * 
	 * @param msg
	 *            信息
	 */
	public void trace(String msg) {
		if (logger.isTraceEnabled()) {
			logger.trace(msg);
		}
	}

	/**
	 * 如果默认的日志管理器支持追踪信息<br/>
	 * 则追踪信息
	 * 
	 * @param msg
	 *            信息
	 * @param obj
	 *            占位符信息
	 */
	public void trace(String msg, Object... obj) {
		if (logger.isTraceEnabled()) {
			logger.trace(msg, obj);
		}
	}


	/**
	 * 如果默认的日志管理器支持追踪信息<br/>
	 * 则追踪信息
	 *
	 * @param msg
	 *            信息
	 * @param cause
	 *            异常
	 */
	public void trace(String msg,Throwable cause) {
		if (logger.isTraceEnabled()) {
			logger.trace(msg, cause);
		}
	}

	/**
	 * 如果默认的日志管理器支持调试信息<br/>
	 * 则调试信息
	 * 
	 * @param msg
	 */
	public void debug(String msg) {
		if (logger.isDebugEnabled()) {
			logger.debug(msg);
		}
	}

	/**
	 * 如果默认的日志管理器支持调试信息<br/>
	 * 则调试信息
	 * 
	 * @param msg
	 * @param obj
	 */
	public void debug(String msg, Object... obj) {
		if (logger.isDebugEnabled()) {
			logger.debug(msg, obj);
		}
	}

	/**
	 * 如果默认的日志管理器支持调试信息<br/>
	 * 则调试信息
	 *
	 * @param msg
	 * @param cause
	 */
	public void debug(String msg, Throwable cause) {
		if (logger.isDebugEnabled()) {
			logger.debug(msg, cause);
		}
	}

	/**
	 * 如果默认的日志管理器支持警告信息<br/>
	 * 则警告信息
	 * 
	 * @param msg
	 */
	public void warn(String msg) {
		if (logger.isWarnEnabled()) {
			logger.warn(msg);
		}
	}

	/**
	 * 如果默认的日志管理器支持警告信息<br/>
	 * 则警告信息
	 * 
	 * @param msg
	 * @param obj
	 */
	public void warn(String msg, Object... obj) {
		if (logger.isWarnEnabled()) {
			logger.warn(msg, obj);
		}
	}

	/**
	 * 如果默认的日志管理器支持警告信息<br/>
	 * 则警告信息
	 *
	 * @param msg
	 * @param cause
	 */
	public void warn(String msg, Throwable cause) {
		if (logger.isWarnEnabled()) {
			logger.warn(msg, cause);
		}
	}

	/**
	 * 如果默认的日志管理器支持报错信息<br/>
	 * 则报错信息
	 * 
	 * @param msg
	 */
	public void error(String msg) {
		if (logger.isErrorEnabled()) {
			logger.error(msg);
		}
	}

	/**
	 * 如果默认的日志管理器支持报错信息<br/>
	 * 则报错信息
	 * 
	 * @param msg
	 * @param obj
	 */
	public void error(String msg, Object... obj) {
		if (logger.isErrorEnabled()) {
			logger.error(msg, obj);
		}
	}

	/**
	 * 如果默认的日志管理器支持报错信息<br/>
	 * 则报错信息
	 *
	 * @param msg
	 * @param cause
	 */
	public void error(String msg, Throwable cause) {
		if (logger.isErrorEnabled()) {
			logger.error(msg, cause);
		}
	}
}
