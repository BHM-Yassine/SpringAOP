package com.ensa.aspect;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;

import com.ensa.entities.Compte;


public class AroundAop implements MethodInterceptor {

	static Logger logger = Logger.getLogger(AroundAop.class);

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object result = null;

		logger.info("L'invocation de la méthode :" + invocation.getMethod().getName() + ", les arguments: "
				+ Arrays.toString(invocation.getArguments()));

		if (invocation.getMethod().getName().equals("setSolde")) {
			result = invocation.proceed();
		} else if (invocation.getMethod().getName().equals("retirer")) {
			Compte cp = (Compte) invocation.getThis();
			Double mt = (Double) invocation.getArguments()[0];

			if (cp.getSolde() > mt) {
				Long d1 = System.currentTimeMillis();
				result = invocation.proceed();
				Long d2 = System.currentTimeMillis();
				Long diff = d2 - d1;

				logger.info("le compte a été débiter, et le nouveau solde est " + cp.getSolde());
				logger.info("La durée d'éxecution de la méthode est: " + diff);
			} else {
				logger.info("Solde insuffisant");
			}

		} else if (invocation.getMethod().getName().equals("verser")) {
			Compte cpp = (Compte) invocation.getThis();

			Long d1 = System.currentTimeMillis();
			result = invocation.proceed();
			Long d2 = System.currentTimeMillis();
			Long diff = d2 - d1;

			logger.info("Le virement effectué, et le nouveau solde est " + cpp.getSolde());
			logger.info("La durée d'éxecution de la méthode est: " + diff);
		}
		return result;
	}

}
