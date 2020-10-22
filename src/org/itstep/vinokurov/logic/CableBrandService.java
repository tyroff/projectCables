package org.itstep.vinokurov.logic;

import java.util.List;

// E - passed entity;
// T - passed type;
public interface CableBrandService<E, T> extends SaveByIdesService<T> {
	
	List<E> findByIdes(T... id) throws LogicException;
}
