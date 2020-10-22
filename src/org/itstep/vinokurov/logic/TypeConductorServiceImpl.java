package org.itstep.vinokurov.logic;

import java.util.List;

import org.itstep.vinokurov.domain.TypeConductor;
import org.itstep.vinokurov.storage.TypeConductorDao;
import org.itstep.vinokurov.storage.DaoException;

public class TypeConductorServiceImpl implements TypeConductorService<TypeConductor, Long>{
	private TypeConductorDao<TypeConductor, Long> typeConductorDao;
	
	public void setTypeConductorDao(TypeConductorDao<TypeConductor, Long> typeConductorDao) {
		this.typeConductorDao = typeConductorDao;
	}

	@Override
	public List<TypeConductor> findAll() throws LogicException {
		try {
			List<TypeConductor> typeConductors = typeConductorDao.readAll();
			return typeConductors;
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public TypeConductor findById(Long id) throws LogicException {
		try {
			return typeConductorDao.read(id);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}
}
