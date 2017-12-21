package com.imie.model;

import java.util.ArrayList;
import java.util.List;

import com.imie.Bar;
import com.imie.Cuisine;
import com.imie.Salle;

public class Restaurant {
	private Waiter serveur;
	private Bar bar;
	private Cuisine cuisine;
	private Salle salle;
	private Menu menu;
	private List<Table> tables = new ArrayList<>();
	private int commandeCounter = 0;

	public List<Table> getTables() {
		return this.tables;
	}

	public void add(Table table) {
		this.tables.add(table);
	}

	public void add(Waiter waiter) {
		this.serveur = waiter;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Menu getMenu() {
		return menu;
	}

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public int getCommandeCounter() {
		commandeCounter++;
		return commandeCounter;
	}

	public boolean hasTableFree() {
		boolean isFree = false;

		for (Table table: this.tables) {
			if (table.getClient() == null) {
				isFree = true;
				break;
			}
		}

		return isFree;
	}

	public boolean hasTableOccupe() {
		boolean isOccupe = false;

		for (Table table: this.tables) {
			if (table.getClient() != null) {
				isOccupe = true;
				break;
			}
		}

		return isOccupe;
	}
}
