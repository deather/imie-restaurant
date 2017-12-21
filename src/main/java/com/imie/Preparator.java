package com.imie;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.imie.model.Article;
import com.imie.model.Commande;

public abstract class Preparator<T extends Article, R extends NotifierParam> extends Notifieur<R> implements Notifiable<Commande> {
	private Salle salle;
	private ExecutorService executorService = Executors.newFixedThreadPool(1);

	public void shutdown() {
		executorService.shutdownNow();
	}
}
