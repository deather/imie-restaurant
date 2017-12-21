package com.imie.model;

import java.util.ArrayList;
import java.util.List;

public class Commande {
	private int id;
	private Table table;
	private List<Article> articles;
	private List<Article> articlesPret;
	private Client client;

	public Commande(int i, List<Article> articles, Table table) {
		this.id = i;
		this.articles = articles;
		this.articlesPret = new ArrayList<>();
		this.table = table;
		this.client = table.getClient();
	}

	public int getId() {
		return id;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public List<Article> getArticlesPret() {
		return articlesPret;
	}

	public Client getClient() {
		return client;
	}

	public boolean estPrete() {
		boolean commandeEstPrete = true;

		for (Article a: this.articles) {
			if (!this.articlesPret.contains(a)) {
				commandeEstPrete = false;
				break;
			}
		}

		return commandeEstPrete;
	}
}
