package com.imie.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	private Waiter serveur;
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
}
