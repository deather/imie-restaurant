package com.imie.model;

public class Client {
	private String name;
	private Table table;

	public Client(String nomClient) {
		this.name = nomClient;
	}

	public void setTable(Table table) {
		this.table = table;
	}
}
