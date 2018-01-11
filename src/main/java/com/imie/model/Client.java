package com.imie.model;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(generator = "seq_client_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_client_id", sequenceName = "seq_client_id", allocationSize = 1)
	private int id;

	@Column(nullable = false)
	private String name;

	@OneToOne
	private Table table;

	public Client() {
	}

	public Client(String nomClient) {
		this.name = nomClient;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public String getName() {
		return name;
	}

	public Table getTable() {
		return table;
	}

	public int getId() {
		return id;
	}
}
