package org.itstep.vinokurov.logic;

public interface SaveByEntityService<E> {
	void save(E entity) throws LogicException;
}
