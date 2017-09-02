package org.aming.gwms.invocationhandler;

import org.aming.gwms.logger.AmingLogger;
import org.aming.gwms.logger.AmingLoggerManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author daming
 * @version 2017/7/6.
 */
public class DaoInvocationHandler implements InvocationHandler {

    private static AmingLogger logger = AmingLoggerManager.getLogger("daologger");

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
