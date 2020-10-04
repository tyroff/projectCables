package org.itstep.vinokurov.logic;

import java.util.Set;

public interface FindByIdService<T>{	
	Set<T> findById(T... id) throws LogicException;
}
