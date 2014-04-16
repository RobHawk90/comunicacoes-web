package com.example.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.models.User;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserService {

	@GET
	public User add() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

		User user = new User();
		user.setNome("master");
		user.setSenha("padrao");
		manager.persist(user);

		transaction.commit();
		manager.close();

		return user;
	}
}
