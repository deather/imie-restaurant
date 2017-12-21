package com.imie.core;

import com.imie.model.Aliment;
import com.imie.model.Article;
import com.imie.model.Commande;

public class Cuisine {

	private Salle salle;

	public void preparer(Aliment aliment, Commande commandeAPreparer) {
		// Prépare l'aliment
		salle.aServir(aliment, commandeAPreparer);
	}

	public void aPreparer(Commande commandeAPreparer) {
		for (Article article : commandeAPreparer.getArticles()) {
			if (article instanceof Aliment) {
				this.preparer((Aliment) article, commandeAPreparer);
			}
		}
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
}
