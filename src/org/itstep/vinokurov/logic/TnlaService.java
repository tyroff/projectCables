package org.itstep.vinokurov.logic;

import java.util.List;

import org.itstep.vinokurov.domain.Tnla;

public interface TnlaService {
	
	List<Tnla> findAll() throws LogicException;
	
	void save(Tnla tnla) throws LogicException;
	
	void delete(Long id) throws LogicException;
}
