package org.itstep.vinokurov.logic;

import java.util.Set;

public interface FindBySetIdesService<T>{	
	Set<T> findBySetIdes(T... id) throws LogicException;
}
