package com.example.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.models.Usuario;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
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
		if (usuario.getNome().equals("master") && usuario.getSenha().equals("padrao"))
			return Response.ok().entity(usuario).build();
		else
			return Response.status(401).entity(usuario).build();
	}
}
