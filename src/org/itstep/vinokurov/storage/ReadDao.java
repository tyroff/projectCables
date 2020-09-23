package org.itstep.vinokurov.storage;

public interface ReadDao<T, S>{
	T read(S... id) throws DaoException;
}
