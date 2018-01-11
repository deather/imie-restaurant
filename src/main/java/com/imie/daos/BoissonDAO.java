package com.imie.daos;

import javax.persistence.EntityManager;

import com.imie.model.Boisson;
import com.imie.utils.EntityManagerHolder;

public class BoissonDAO {
	private EntityManager entityManager = EntityManagerHolder.get().createEntityManager();

	public Boisson create(Boisson boisson) {
		entityManager.getTransaction().begin();
		entityManager.persist(boisson);
		entityManager.getTransaction().commit();

		return boisson;
	}
}
