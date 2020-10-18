package org.itstep.vinokurov.logic;

public interface SaveByIdService<T> {
	void save(T... id) throws LogicException;
}
