package com.imie;

import java.util.List;

import com.imie.model.Aliment;
import com.imie.model.Article;
import com.imie.model.Commande;

public class Cuisine extends Preparator<Aliment, Cuisine.CuisineNotifierParam> {
	public class CuisineNotifierParam implements NotifierParam {
		public int commandeId;
		public Aliment aliment;

		public CuisineNotifierParam(int commandeId, Aliment aliment) {
			this.commandeId = commandeId;
			this.aliment = aliment;
		}
	}

	@Override
	public void estNotifie(Commande commande) {
		List<Article> articles = commande.getArticles();

		for (Article article : articles) {
			if (article instanceof  Aliment) {
//				Thread.currentThread().sleep(article.getTempsPreparation() * 1000);

				this.notifier(new CuisineNotifierParam(commande.getId(), (Aliment) article));
			}
		}
	}
}
