package br.robhawk.java.comunicacoes.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.robhawk.java.comunicacoes.dao.UsuarioDao;
import br.robhawk.java.comunicacoes.models.Usuario;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioServices {

	@POST
	@Path("/login")
	public Response login(Usuario usuario) {
		UsuarioDao dao = new UsuarioDao();

		if (dao.login(usuario))
			return Response.ok().entity(usuario).build();
		else
			return Response.status(401).entity(usuario).build();
	}
}
