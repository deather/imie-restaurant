package com.imie.model;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "\"table\"")
public class Table {
	@Id
	@GeneratedValue(generator = "seq_table_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_table_id", sequenceName = "seq_table_id", allocationSize = 1)
	private int id;

	@OneToOne
	private Client client;

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
