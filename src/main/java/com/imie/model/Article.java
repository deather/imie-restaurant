package com.imie.model;

public abstract class Article {
	protected int id;
	protected String name;
	protected double prix;
	protected int tempsPreparation;

	protected Article(int id, String name, double prix, int tempsPreparation) {
		this.id = id;
		this.name = name;
		this.prix = prix;
		this.tempsPreparation = tempsPreparation;
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

	public int getTempsPreparation() {
		return tempsPreparation;
	}

	public abstract String toString();
}
