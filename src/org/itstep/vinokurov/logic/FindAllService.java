package org.itstep.vinokurov.logic;

import java.util.List;

public interface FindAllService<E>{	
	List<E> findAll() throws LogicException;
}
