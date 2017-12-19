package com.imie.model;

public abstract class Article {
	protected int id;
	protected String name;
	protected double prix;

	protected Article(int id, String name, double prix) {
		this.id = id;
		this.name = name;
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrix() {
		return prix;
	}

	public abstract String toString();
}
