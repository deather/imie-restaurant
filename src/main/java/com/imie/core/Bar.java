package com.imie.core;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.imie.daos.CommandeDAO;
import com.imie.model.Aliment;
import com.imie.model.Article;
import com.imie.model.Boisson;
import com.imie.model.Commande;

public class Bar {

	private ExecutorService executorService = Executors.newFixedThreadPool(1);
	private Salle salle;
	private CommandeDAO commandeDAO = new CommandeDAO();

	public void preparer(Boisson boisson, Commande commandeAPreparer) {
		executorService.submit(() -> {
			try {
				Thread.currentThread().sleep(boisson.getTempsPreparation() * 1000);
				Commande commandeDB = this.commandeDAO.get(commandeAPreparer.getId());

				commandeDB.getArticlesPret().add(boisson);
				this.commandeDAO.update(commandeDB);
				salle.aServir(boisson, commandeAPreparer);
			} catch(InterruptedException e) { }
		});
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
