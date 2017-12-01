package com.imie.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<Article> articles;

	public Menu(List<Article> articles) {
		this.articles = articles;
	}

	public List<Article> getArticles(List<Integer> articlesId) {
		List<Article> articlesFound = new ArrayList<>();

		for(Integer articleIdNeeded : articlesId) {
			for(Article article : this.articles) {
				if (article.getId() == articleIdNeeded)
					articlesFound.add(article);
			}
		}

		return articlesFound;
	}
}
