package com.ensa.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class AfterAop implements AfterReturningAdvice {
	static Logger logger = Logger.getLogger(AfterAop.class);

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		logger.info("Apr�s l'invocation de la m�thode :" + method.getName() + ", les arguments: " +Arrays.toString(args));
	}

}
