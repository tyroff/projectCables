package org.itstep.vinokurov.logic;

import java.util.List;

import org.itstep.vinokurov.domain.CableCategory;

public interface CableCategoryService {
	
	List<CableCategory> findAll() throws LogicException;

	void save(CableCategory cableCategory) throws LogicException;

	void delete(Long id) throws LogicException;

}
