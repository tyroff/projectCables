package org.itstep.vinokurov.logic;

public interface SaveByIdesService<T> {
	void saveByIdes(T... id) throws LogicException;
}
