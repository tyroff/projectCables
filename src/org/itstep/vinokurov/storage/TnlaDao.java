package org.itstep.vinokurov.storage;

import java.util.List;

import org.itstep.vinokurov.domain.Tnla;

public interface TnlaDao extends Dao<Tnla> {
	List<Tnla> read() throws DaoException;
}
