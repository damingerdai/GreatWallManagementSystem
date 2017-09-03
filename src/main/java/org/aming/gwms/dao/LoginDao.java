package org.aming.gwms.dao;

/**
 * @author daming
 * @version 2017/7/4.
 */
public interface LoginDao {

    int verify(String name,String password);
}
