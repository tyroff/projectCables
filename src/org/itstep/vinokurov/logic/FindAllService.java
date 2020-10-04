package org.itstep.vinokurov.logic;

import java.util.List;

import org.itstep.vinokurov.domain.Tnla;

public interface FindAllService<T>{	
	List<T> findAll() throws LogicException;
}
