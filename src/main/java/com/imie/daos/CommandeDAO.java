package com.imie.daos;

import javax.persistence.EntityManager;

import com.imie.model.Commande;
import com.imie.utils.EntityManagerHolder;

public class CommandeDAO {

	private EntityManager entityManager = EntityManagerHolder.get().createEntityManager();

	public Commande create(Commande commande) {
		entityManager.getTransaction().begin();
		entityManager.persist(commande);
		entityManager.getTransaction().commit();

		return commande;
	}

	public Commande get(int id) {
		return entityManager.find(Commande.class, id);
	}

	public Commande update(Commande commande) {
		entityManager.getTransaction().begin();
		entityManager.merge(commande);
		entityManager.getTransaction().commit();

		return commande;
	}
}
