package org.aming.gwms.service.impl;

import org.aming.gwms.dao.LoginDao;
import org.aming.gwms.domain.User;
import org.aming.gwms.factory.DaoFactory;
import org.aming.gwms.service.LoginService;

import javax.servlet.http.HttpSession;

/**
 * @author daming
 * @version 2017/7/5.
 */
public class LoginServiceImpl implements LoginService {
	
	private LoginDao loginDao = DaoFactory.getLoginDao();

	@Override
    public boolean verify(User user) {
        return loginDao.verify(user.getEmpId(), user.getPassword()) > 0;
    }

    @Override
    public boolean login(User user,HttpSession session) {
        if(verify(user)){
            user = loginDao.getUser(user.getEmpId());
            session.setAttribute("user", user);
        }
        return false;
    }
}
