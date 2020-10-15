package org.itstep.vinokurov.storage;

public interface CreateByIdesDao<T>{
	void create(T... id) throws DaoException;
}
