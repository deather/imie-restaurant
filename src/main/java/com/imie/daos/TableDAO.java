package com.imie.daos;

import javax.persistence.EntityManager;

import com.imie.model.Table;
import com.imie.utils.EntityManagerHolder;

public class TableDAO {

	private EntityManager entityManager = EntityManagerHolder.get().createEntityManager();

	public Table create(Table table) {
		entityManager.getTransaction().begin();
		entityManager.persist(table);
		entityManager.getTransaction().commit();

		return table;
	}

	public Table update(Table table) {
		entityManager.getTransaction().begin();
		entityManager.merge(table);
		entityManager.getTransaction().commit();

		return table;
	}

	public Table get(int id) {
		return entityManager.find(Table.class, id);
	}
}
