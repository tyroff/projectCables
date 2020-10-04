package org.itstep.vinokurov.storage;

public interface CreateDao<T>{
	void create(T... id) throws DaoException;
}
