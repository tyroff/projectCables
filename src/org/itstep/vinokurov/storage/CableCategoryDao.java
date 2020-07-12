package org.itstep.vinokurov.storage;

import java.util.List;

import org.itstep.vinokurov.domain.CableCategory;

public interface CableCategoryDao extends Dao<CableCategory> {

	List<CableCategory> read() throws DaoException;
	
}
