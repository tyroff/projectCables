package org.itstep.vinokurov.storage;

import java.util.List;

// E - passed entity;
// T - passed wrapper class;
public interface CableBrandDao<E, T> extends ReadDao<List<E>, T>, CreateByIdesDao<T> {

	List<E> read(T... id) throws DaoException;}
