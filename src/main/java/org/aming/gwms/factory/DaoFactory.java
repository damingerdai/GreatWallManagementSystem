package org.aming.gwms.factory;

import com.google.common.collect.Maps;
import org.aming.gwms.dao.LoginDao;
import org.aming.gwms.dao.impl.LoginDaoImpl;

import java.util.Map;

/**
 * Dao工厂
 * @author daming
 * @version 2017/7/4.
 */
public class DaoFactory {

    private static Map<Class<?>,Object> currentMap = Maps.newConcurrentMap();

    public static LoginDao buildLoginDao(){
       if(currentMap.get(LoginDao.class) == null){
           LoginDaoImpl target = new LoginDaoImpl();

       }
        return null;
    }
}
