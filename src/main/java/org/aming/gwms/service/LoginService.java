package org.aming.gwms.service;

import org.aming.gwms.domain.User;

/**
 * 登录模块的service
 * @author daming
 * @version 2017/7/4.
 */
public interface LoginService {
    /**
     * 验证用户是否存在
     * @param user
     * @return
     */
    int verify(User user);
}
