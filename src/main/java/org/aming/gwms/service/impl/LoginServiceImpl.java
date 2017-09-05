package org.aming.gwms.service.impl;

import org.aming.gwms.dao.LoginDao;
import org.aming.gwms.domain.User;
import org.aming.gwms.factory.DaoFactory;
import org.aming.gwms.service.LoginService;

/**
 * @author daming
 * @version 2017/7/5.
 */
public class LoginServiceImpl implements LoginService {
	
	private LoginDao loginDao = DaoFactory.getLoginDao();

    public boolean verify(User user) {
        return loginDao.verify(user.getEmpId(), user.getPassword()) > 0;
    }
}
