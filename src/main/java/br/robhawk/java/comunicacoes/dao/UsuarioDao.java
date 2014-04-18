package br.robhawk.java.comunicacoes.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.robhawk.java.comunicacoes.models.Usuario;
import br.robhawk.java.comunicacoes.utils.EntityUtils;

public class UsuarioDao implements Dao<Usuario> {

	private EntityManager manager;

	public UsuarioDao() {
		manager = EntityUtils.createEntityManager();
	}

	public void insert(Usuario object) {
		manager.getTransaction().begin();
		manager.persist(object);
		manager.getTransaction().commit();
	}

	public Usuario update(Usuario object) {
		manager.getTransaction().begin();
		Usuario usuario = manager.merge(object);
		manager.getTransaction().commit();

		return usuario;
	}

	public void delete(Usuario object) {
		manager.getTransaction().begin();
		manager.remove(object);
		manager.getTransaction().commit();
	}

	public List<Usuario> select() {
		manager.getTransaction().begin();
		TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM Usuario u", Usuario.class);
		List<Usuario> usuarios = query.getResultList();
		manager.getTransaction().commit();

		return usuarios;
	}

	public List<Usuario> selectBy(Object filter) {
		// TODO selectBy
		return null;
	}

	public Usuario findBy(Object id) {
		manager.getTransaction().begin();
		Usuario usuario = manager.find(Usuario.class, id);
		manager.getTransaction().commit();

		return usuario;
	}

	public boolean login(Usuario usuario) {
		manager.getTransaction().begin();
		TypedQuery<Usuario> query = manager.createQuery(
				"SELECT u FROM Usuario u WHERE nome = :nome AND senha = :senha", Usuario.class);

		return query.getSingleResult() != null;
	}
}
