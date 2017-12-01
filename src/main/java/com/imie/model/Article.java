package com.imie.model;

public class Article {
	private int id;
	private String name;

	public Article(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
