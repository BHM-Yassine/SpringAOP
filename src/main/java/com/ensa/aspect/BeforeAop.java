package com.ensa.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeAop implements MethodBeforeAdvice {
	static Logger logger = Logger.getLogger(BeforeAop.class);

	public void before(Method method, Object[] args, Object target) throws Throwable {
		logger.info("Avant l'invocation de la méthode :" + method.getName() + ", les arguments: " +Arrays.toString(args));
	}

}
