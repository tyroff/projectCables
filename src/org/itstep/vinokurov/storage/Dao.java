package org.itstep.vinokurov.storage;

import org.itstep.vinokurov.domain.Entity;

public interface Dao<T extends Entity> {
	
	Long create(T entity) throws DaoException;
	
	T read(Long id) throws DaoException;
	
	void update(T entity) throws DaoException;
}
