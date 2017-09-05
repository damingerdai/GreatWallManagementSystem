package org.aming.gwms.exceptions;

import java.sql.SQLException;

public class Exceptions {
    public static RuntimeException toRuntimeException(Throwable cause) {
        if (cause instanceof RuntimeException) {
            return (RuntimeException) cause;
        } else {
            return new RuntimeException(cause);
        }
    }

    public static AmingException toAmingException(Throwable cause){
        if(cause instanceof AmingException){
            return (AmingException)cause;
        } else if(cause instanceof SQLException){
            SQLException ex = (SQLException)cause;
            return new AmingException(String.valueOf(ex.getErrorCode()),ex.getMessage(),ex.getCause());
        } else{
            return new AmingException(cause);
        }
    }
}
