package org.aming.gwms.dao.impl;

import org.aming.gwms.dao.LoginDao;
import org.aming.gwms.jdbc.JdbcUtils;
import org.aming.gwms.utils.EncodeUtils;

/**
 * @author daming
 * @version 2017/7/4.
 */
public class LoginDaoImpl implements LoginDao {
	

    private final static String SQL_VERIFY_USER = " SELECT COUNT(empid) FROM employee WHERE empid = ? AND `password` = ? ";

    public int verify(String empId, String password) {
        return JdbcUtils.queryCount(SQL_VERIFY_USER,new Object[]{empId, EncodeUtils.md5Hex(password)});
    }
}
