package com.imie.daos;

import javax.persistence.EntityManager;

import com.imie.model.Aliment;
import com.imie.utils.EntityManagerHolder;

public class AlimentDAO {
	private EntityManager entityManager = EntityManagerHolder.get().createEntityManager();

	public Aliment create(Aliment aliment) {
		entityManager.getTransaction().begin();
		entityManager.persist(aliment);
		entityManager.getTransaction().commit();

		return aliment;
	}
}
