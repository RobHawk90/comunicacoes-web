package br.robhawk.java.comunicacoes.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.core.InjectParam;

import br.robhawk.java.comunicacoes.dao.UsuarioDao;
import br.robhawk.java.comunicacoes.models.Usuario;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioServices {

	@InjectParam
	UsuarioDao dao;

	@POST
	@Path("/login")
	public Response login(Usuario usuario) {

		if (dao.login(usuario))
			return Response.ok().entity(usuario).build();
		else
			return Response.status(401).entity(usuario).build();
	}

	@GET
	@Path("/addMasterUser")
	public Usuario addMasterUser() {
		Usuario usuario = new Usuario();

		usuario.setNome("master");
		usuario.setSenha("padrao");

		dao.insert(usuario);

		return usuario;
	}
}
