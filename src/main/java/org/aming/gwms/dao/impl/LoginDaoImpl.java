package org.aming.gwms.dao.impl;

import org.aming.gwms.dao.LoginDao;

/**
 * @author daming
 * @version 2017/7/4.
 */
public class LoginDaoImpl implements LoginDao {

    private final static String SQL_VERIFY = "SELECT * ";

    public int verify(String name, String password) {
        return 0;
    }
}
