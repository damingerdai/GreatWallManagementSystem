package org.aming.gwms.exceptions;

public class Exceptions {
	public static RuntimeException toRuntimeException(Throwable cause){
		if(cause instanceof RuntimeException){
			return (RuntimeException)cause;
		}else{
			return new RuntimeException(cause);
		}
	}
	
}
