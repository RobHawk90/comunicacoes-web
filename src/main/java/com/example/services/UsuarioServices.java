package com.example.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.models.Usuario;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioServices {

	/*
	 * @GET public Usuario add() { EntityManagerFactory factory =
	 * Persistence.createEntityManagerFactory("test"); EntityManager manager =
	 * factory.createEntityManager(); EntityTransaction transaction =
	 * manager.getTransaction();
	 * 
	 * transaction.begin();
	 * 
	 * Usuario user = new Usuario(); user.setNome("master");
	 * user.setSenha("padrao"); manager.persist(user);
	 * 
	 * transaction.commit(); manager.close();
	 * 
	 * return user; }
	 */

	@POST
	@Path("/login")
	public Response login(Usuario usuario) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

		TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u where u.nome = " + usuario.getNome()
				+ " and u.senha = " + usuario.getSenha(), Usuario.class);

		transaction.commit();

		Usuario master = query.getResultList().get(0);

		if (master != null)
			return Response.ok().build();
		else
			return Response.noContent().build();

	}
}
