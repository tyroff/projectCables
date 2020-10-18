package org.itstep.vinokurov.storage;

public interface CreateDao<E, T>{
	T create(E entity) throws DaoException;
}
