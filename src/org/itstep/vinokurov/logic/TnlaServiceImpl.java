package org.itstep.vinokurov.logic;

import java.util.List;

import org.itstep.vinokurov.domain.Tnla;
import org.itstep.vinokurov.storage.DaoException;
import org.itstep.vinokurov.storage.TnlaDao;

public class TnlaServiceImpl implements TnlaService {
	private TnlaDao tnlaDao;

	public void setTnlaDao(TnlaDao tnlaDao) {
		this.tnlaDao = tnlaDao;
	}

	@Override
	public List<Tnla> findAll() throws LogicException {
		try {
			List<Tnla> tnlas = tnlaDao.read();
			return tnlas;
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void save(Tnla tnla) throws LogicException {
		try {
			if(tnla.getId() == null) {
				Long id = tnlaDao.create(tnla);
				tnla.setId(id);
			} else {
				tnlaDao.update(tnla);
			}
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

}
