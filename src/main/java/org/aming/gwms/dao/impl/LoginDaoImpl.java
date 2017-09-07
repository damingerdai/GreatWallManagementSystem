package org.aming.gwms.dao.impl;

import org.aming.gwms.constants.ErrorCodeConstants;
import org.aming.gwms.dao.LoginDao;
import org.aming.gwms.domain.User;
import org.aming.gwms.exceptions.AmingException;
import org.aming.gwms.exceptions.ExceptionBuilder;
import org.aming.gwms.jdbc.JdbcUtils;
import org.aming.gwms.utils.EncodeUtils;

import java.util.List;

/**
 * @author daming
 * @version 2017/7/4.
 */
public class LoginDaoImpl implements LoginDao {
	

    private final static String SQL_VERIFY_USER = " SELECT COUNT(empid) FROM employee WHERE empid = ? AND `password` = ? ";
    @Override
    public int verify(String empId, String password) throws AmingException{
        try{
            return JdbcUtils.queryCount(SQL_VERIFY_USER,new Object[]{empId, EncodeUtils.md5Hex(password)});
        } catch (Exception ex){
            throw ExceptionBuilder.buildAmingException(ErrorCodeConstants.ERROR_DAO,SQL_VERIFY_USER,ex);
        }

    }

    private final static String SQL_GET_USER_BY_EMP_ID = "SELECT empId username,`password`,depId FROM employee A WHERE A.empid = ? ";
    @Override
    public User getUser(String empId) throws AmingException {
        try{
            List<User> result = JdbcUtils.query(SQL_GET_USER_BY_EMP_ID, new Object[]{empId}, rs -> {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setDepId(rs.getString("depId"));
                user.setEmpId(rs.getString("empId"));
                return user;
            });
            if(result == null || result.size() < 1){
                return result.get(0);
            }else{
                //一般而言不会出现
                throw new RuntimeException("user : " + empId + " is not excited");
            }
        }catch (Exception ex){
            throw ExceptionBuilder.buildAmingException(ErrorCodeConstants.ERROR_DAO,SQL_GET_USER_BY_EMP_ID,ex);
        }

    }
}
