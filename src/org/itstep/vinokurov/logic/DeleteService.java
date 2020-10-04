package org.itstep.vinokurov.logic;

public interface DeleteService<T> {
	void delete(T... id) throws LogicException;
}
