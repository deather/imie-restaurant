package com.imie.core2;

import java.util.List;

import com.imie.model.Aliment;
import com.imie.model.Article;
import com.imie.model.Commande;

public class Cuisine extends Preparator<Aliment> {
	@Override
	public void estNotifie(Commande commande) {
		List<Article> articles = commande.getArticles();

		for (Article article : articles) {
			if (article instanceof  Aliment) {
				this.executorService.submit(() -> {
					try {
						Thread.currentThread().sleep(article.getTempsPreparation() * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					this.notifier(new PreparatorNotifierParam(commande.getId(), article));
				});
			}
		}
	}
}
