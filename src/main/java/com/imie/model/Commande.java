package com.imie.model;

import java.util.List;

public class Commande {
	private int id;
	private Table table;
	private List<Article> articles;

	public Commande(int i, List<Article> articles, Table table) {
		this.id = i;
		this.articles = articles;
		this.table = table;
	}

	public int getId() {
		return id;
	}

	public List<Article> getArticles() {
		return articles;
	}
}
