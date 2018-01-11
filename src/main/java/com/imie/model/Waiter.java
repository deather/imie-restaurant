package com.imie.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "waiter")
public class Waiter {
	@Id
	@GeneratedValue(generator = "seq_waiter_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_waiter_id", sequenceName = "seq_waiter_id", allocationSize = 1)
	private Long id;

	@OneToMany
	private Set<Commande> commandes;

	public Long getId() {
		return id;
	}
}
