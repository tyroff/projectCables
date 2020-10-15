package org.itstep.vinokurov.storage;

public interface UpdateDao<E>{
	void update(E entity) throws DaoException;
}
