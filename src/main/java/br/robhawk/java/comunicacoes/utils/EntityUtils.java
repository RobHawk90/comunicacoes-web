package br.robhawk.java.comunicacoes.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityUtils {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("comunicacoes");

	public static EntityManager createEntityManager() {
		return factory.createEntityManager();
	}
}
