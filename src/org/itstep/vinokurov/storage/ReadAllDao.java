package org.itstep.vinokurov.storage;

import java.util.List;

public interface ReadAllDao<T>{
	List<T> readAll() throws DaoException;
}
