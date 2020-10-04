package org.itstep.vinokurov.logic;

public interface SaveService<T> {
	void save(T... id) throws LogicException;
}
