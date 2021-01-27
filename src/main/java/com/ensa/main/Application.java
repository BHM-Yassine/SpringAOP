package com.ensa.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ensa.entities.Compte;
import com.ensa.entities.Client;

public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("SpringContext.xml");
		Compte monCompte = (Compte) ctx.getBean("compteProxy");
		
		monCompte.setSolde(2000);
		Client monClient = new Client("Yassine", monCompte);
		
		monClient.retirer(1000);
		monClient.verser(4000);
	}

}
