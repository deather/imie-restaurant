package com.imie.core;

import com.imie.model.Aliment;
import com.imie.model.Article;
import com.imie.model.Boisson;
import com.imie.model.Commande;

public class Bar {

	private Salle salle;

	public void preparer(Boisson boisson, Commande commandeAPreparer) {
		// Prépare l'boisson
		salle.aServir(boisson, commandeAPreparer);
	}

	public void aPreparer(Commande commandeAPreparer) {
		for (Article article : commandeAPreparer.getArticles()) {
			if (article instanceof Boisson) {
				this.preparer((Boisson) article, commandeAPreparer);
			}
		}
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
}
