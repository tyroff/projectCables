package org.itstep.vinokurov.storage;

import java.util.List;

public interface ReadAllDao<E>{
	List<E> readAll() throws DaoException;
}
