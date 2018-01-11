package com.imie.daos;

import javax.persistence.EntityManager;

import com.imie.model.Client;
import com.imie.utils.EntityManagerHolder;

public class ClientDAO {
	private EntityManager entityManager = EntityManagerHolder.get().createEntityManager();

	public Client create(Client client) {
		entityManager.getTransaction().begin();
		entityManager.persist(client);
		entityManager.getTransaction().commit();

		return client;
	}

	public Client get(int id) {
		return entityManager.find(Client.class, id);
	}

	public Client update(Client clientDb) {
		entityManager.getTransaction().begin();
		entityManager.merge(clientDb);
		entityManager.getTransaction().commit();

		return clientDb;
	}
}
