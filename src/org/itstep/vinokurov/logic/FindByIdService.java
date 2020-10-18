package org.itstep.vinokurov.logic;

public interface FindByIdService<E, T>{	
	E findById(T id) throws LogicException;
}
