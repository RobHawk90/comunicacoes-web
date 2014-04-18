package br.robhawk.java.comunicacoes.dao;

import java.util.List;

public interface Dao<T> {
	void insert(T object);

	T update(T object);

	void delete(T object);

	List<T> select();

	List<T> selectBy(Object filter);

	T findBy(Object id);
}
