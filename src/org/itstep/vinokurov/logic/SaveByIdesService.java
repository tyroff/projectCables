package org.itstep.vinokurov.logic;

public interface SaveByIdesService<T> {
	void save(T... id) throws LogicException;
}
