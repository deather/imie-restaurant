package com.imie.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.imie.model.Aliment;
import com.imie.model.Article;
import com.imie.model.Commande;

public class Cuisine {

	private ExecutorService executorService = Executors.newFixedThreadPool(1);
	private Salle salle;

	public void preparer(Aliment aliment, Commande commandeAPreparer) {
		executorService.submit(() -> {
			try {
				Thread.currentThread().sleep(aliment.getTempsPreparation() * 1000);
				salle.aServir(aliment, commandeAPreparer);
			} catch(InterruptedException e) { }
		});
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
