package com.imie.core2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.imie.model.Article;
import com.imie.model.Commande;

public abstract class Preparator<T extends Article> extends Notifieur<Preparator.PreparatorNotifierParam> implements Notifiable<Commande> {

	public static class PreparatorNotifierParam implements NotifierParam {
		private int commandeId;
		private Article article;

		public PreparatorNotifierParam(int commandeId, Article article) {
			this.commandeId = commandeId;
			this.article = article;
		}
	}

	protected ExecutorService executorService = Executors.newFixedThreadPool(1);

	public void shutdown() {
		executorService.shutdownNow();
	}
}
