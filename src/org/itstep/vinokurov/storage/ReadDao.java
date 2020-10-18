package org.itstep.vinokurov.storage;

public interface ReadDao<E, T>{
	E read(T... id) throws DaoException;
}
