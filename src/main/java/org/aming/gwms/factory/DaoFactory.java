package org.aming.gwms.factory;

import com.google.common.collect.Maps;
import org.aming.gwms.dao.LoginDao;
import org.aming.gwms.dao.impl.LoginDaoImpl;

import java.util.Map;

/**
 * Dao工厂
 * 
 * @author daming
 * @version 2017/7/4.
 */
public class DaoFactory {
	
	public static LoginDao getLoginDao(){
		return DaoHolder.loginDao;
	}

	private static class DaoHolder {
		private static LoginDao loginDao = new LoginDaoImpl();
	}
}
