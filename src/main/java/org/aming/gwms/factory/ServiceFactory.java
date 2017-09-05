package org.aming.gwms.factory;

import org.aming.gwms.service.LoginService;
import org.aming.gwms.service.impl.LoginServiceImpl;

public class ServiceFactory {
	
	public static LoginService getLoginService(){
		return ServiceHolder.loginService;
	}
	
	private static class ServiceHolder{
		private static LoginService loginService = new LoginServiceImpl();
	}
}
