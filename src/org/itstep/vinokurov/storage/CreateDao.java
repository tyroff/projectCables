package org.itstep.vinokurov.storage;

public interface CreateDao<E, T>{
	T create(Long id) throws DaoException;
}
