package org.aming.gwms.dao;

/**
 * 登录模块的DAO
 * @author daming
 * @version 2017/7/4.
 */
public interface LoginDao {

    /**
     * 验证用户是否存在
     * @param name
     * @param password
     * @return
     */
    int verify(String name,String password);
}
