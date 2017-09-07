package org.aming.gwms.dao;

import org.aming.gwms.domain.User;
import org.aming.gwms.exceptions.AmingException;

/**
 * @author daming
 * @version 2017/7/4.
 */
public interface LoginDao {

    int verify(String empId,String password) throws AmingException;

    User getUser(String empId) throws AmingException;
}
