package org.itstep.vinokurov.storage;

public interface DeleteDao<T>{
	void delete(T... id) throws DaoException;
}
