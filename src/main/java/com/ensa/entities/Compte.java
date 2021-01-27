package com.ensa.entities;

import org.springframework.stereotype.Component;

public class Compte {
	private double solde;

	public Compte() {
	}
	
	public Compte(int i) {
		this.solde = i;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public void retirer(double mt) {
		this.solde -= mt;
	}

	public void verser(double mt) {
		solde += mt;
	}
}
