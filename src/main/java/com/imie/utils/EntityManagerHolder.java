package com.imie.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Cette classe est un Singleton détenant l'instance de l'{@link EntityManagerFactory}.
 */
public class EntityManagerHolder {

	// Singleton
	private static EntityManagerHolder _instance;
	private final EntityManagerFactory entityManagerFactory;

	private EntityManagerHolder() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("restaurant-jpa");
	}

	public EntityManager createEntityManager() {
		return this.entityManagerFactory.createEntityManager();
	}

	public void close() {
		this.entityManagerFactory.close();
	}

	public static EntityManagerHolder get() {
		// Si l'instance n'existe pas on en crée une nouvelle
		if (_instance == null)
			_instance = new EntityManagerHolder();

		return _instance;
	}
}
