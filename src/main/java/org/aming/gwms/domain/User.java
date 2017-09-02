package org.aming.gwms.domain;

import org.aming.gwms.utils.StringUtils;

/**
 * 用户实体类
 * @author daming
 * @version 2017/7/4.
 */
public class User {

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    @Override
    public String toString(){
        return StringUtils.reflectionToString(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
