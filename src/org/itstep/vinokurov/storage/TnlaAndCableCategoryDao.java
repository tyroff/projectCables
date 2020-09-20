package org.itstep.vinokurov.storage;

import java.util.Set;

import org.itstep.vinokurov.domain.TnlaAndCableCategory;

public interface TnlaAndCableCategoryDao extends Dao<TnlaAndCableCategory> {
	Set<TnlaAndCableCategory> read() throws DaoException;
}
