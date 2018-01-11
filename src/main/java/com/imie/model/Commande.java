package com.imie.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "commande")
public class Commande {
	@Id
	@GeneratedValue(generator = "seq_commande_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_commande_id", sequenceName = "seq_commande_id", allocationSize = 1)
	private int id;

	@ManyToOne
	private Table table;

	@ManyToOne
	private Waiter waiter;

	@ManyToMany
	private List<Article> articles;

	@CollectionTable(name = "commande_articles_pret")
	@ManyToMany
	private List<Article> articlesPret;

	public Commande() {
	}

	public Commande(List<Article> articles, Table table) {
		this.articles = articles;
		this.articlesPret = new ArrayList<>();
		this.table = table;
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
		return table.getClient();
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
