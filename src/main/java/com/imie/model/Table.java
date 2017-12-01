package com.imie.model;

public class Table {
	private int id;
	private Client client;

	public Table(int id) {
		this.id = id;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public Client getClient() {
		return client;
	}
}
