package com.imie.core;

import java.util.ArrayList;
import java.util.List;

import com.imie.model.Article;
import com.imie.model.Client;
import com.imie.model.Commande;

public class Salle {
	private List<Client> clientsPretApartir = new ArrayList<>();

	private Cuisine cuisine;

	private Bar bar;

	public List<Client> getClientsPretApartir() {
		return clientsPretApartir;
	}

	public void envoyer(Commande commande) {
		this.cuisine.aPreparer(commande);
		this.bar.aPreparer(commande);
	}

	public void aServir(Article articlePret, Commande commande) {
		System.out.println("L'article " + articlePret.toString() + " de la commande " + commande.getId() + " est pret");
		commande.getArticlesPret().add(articlePret);

		if (commande.estPrete()) {
			this.clientsPretApartir.add(commande.getClient());
		}
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}
}
